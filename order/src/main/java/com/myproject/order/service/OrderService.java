package com.myproject.order.service;

import com.myproject.dto.InvoiceDTO;
import com.myproject.order.model.Order;
import com.myproject.order.model.OrderStatus;

import java.util.Optional;

public interface OrderService {

    Optional<Order> save(Order order);

    void updateStatus(Order order, OrderStatus status);

    Optional<Order> findById(Long orderId);

    void consumeKafkaRecord(InvoiceDTO invoiceDTO);
}
