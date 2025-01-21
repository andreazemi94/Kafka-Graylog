package com.myproject.order.service;

import com.myproject.dto.*;
import com.myproject.order.graylog.GraylogProducer;
import com.myproject.order.kafka.KafkaProducer;
import com.myproject.order.model.*;
import com.myproject.order.repository.OrderRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("OrderService v1.0")
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final KafkaProducer kafkaProducer;
    private final GraylogProducer graylogProducer;
    private final ModelMapper modelMapperOrder;
    @Value("${server.address:localhost}")
    private String host;
    @Value("${server.port}")
    private String port;
    private String source;

    @PostConstruct
    private void setSource(){
        this.source = host + ":" + port;
    }

    @Transactional
    @Override
    public Optional<Order> save(Order order) {
        if(orderRepository.findById(order.getOrderId()).isPresent())
            return Optional.empty();
        return Optional.of(create(order));

    }

    private Order create(Order order){
        order.setStatus(OrderStatus.PROCESSING);
        graylogProducer.sendLogMessage(source, "Set order status: " + order, 1);
        order.setOrderDate(new Date());
        graylogProducer.sendLogMessage(source, "Set order date: " + order, 1);
        orderRepository.save(order);
        graylogProducer.sendLogMessage(source, "Order created successfully in the database: " + order, 1);
        kafkaProducer.sendMessage(source, order.getOrderId().toString(), modelMapperOrder.map(order, OrderDto.class), Order.class);
        return order;
    }

    @Transactional
    @Override
    public void updateStatus(Order order, OrderStatus status) {
        order.setStatus(status);
        graylogProducer.sendLogMessage(source, "Set order status: " + order, 1);
        save(order);
    }

    @Override
    public Optional<Order> findById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public void consumeKafkaRecord(InvoiceDTO invoiceDTO) {
        graylogProducer.sendLogMessage(source,"Receive invoice: " + invoiceDTO,1);
        Optional<Order> optOrder = findById(invoiceDTO.getOrderId());
        optOrder.ifPresentOrElse(
                order-> updateStatus(order, OrderStatus.PAYMENT_COMPLETED),
                () -> graylogProducer.sendLogMessage(source,"Order with id " + invoiceDTO.getOrderId() + " not found on db: ", 5)
        );
    }
}
