package com.myproject.invoice.service;

import com.myproject.dto.InvoiceDTO;
import com.myproject.dto.OrderDto;
import com.myproject.invoice.graylog.GraylogProducer;
import com.myproject.invoice.kafka.KafkaProducer;
import com.myproject.invoice.model.Invoice;
import com.myproject.invoice.repository.InvoiceRepository;
import io.confluent.kafka.schemaregistry.client.rest.exceptions.RestClientException;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Date;

@Service("OrderService v1.0")
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final KafkaProducer kafkaProducer;
    private final GraylogProducer graylogProducer;
    private final ModelMapper modelMapperInvoice;
    @Value("${server.address:localhost}")
    private String host;
    @Value("${server.port}")
    private String port;
    private String source;

    @PostConstruct
    private void setSource(){
        this.source = host + ":" + port;
    }

    @Override
    public Invoice save(Invoice invoice) {
        try {
            invoiceRepository.save(invoice);
            graylogProducer.sendLogMessage(source,"Invoice created successfully in the database: " + invoice, 1);
            kafkaProducer.sendMessage(source,invoice.getInvoiceId().toString(), modelMapperInvoice.map(invoice, InvoiceDTO.class), Invoice.class);
        } catch (RestClientException | IOException e) {
            graylogProducer.sendLogMessage(source,"Error to create invoice in the database: " + e.getMessage(), 5);
        }
        return invoice;
    }

    @Override
    public void consumeKafkaRecord(OrderDto orderDto) {
        graylogProducer.sendLogMessage(source,"Receive order: " + orderDto,1);
        Invoice invoice = buildInvoiceFromKafkaRecord(orderDto);
        graylogProducer.sendLogMessage(source,"Build invoice: " + invoice + " from order " + orderDto,1);
        save(invoice);
    }

    private Invoice buildInvoiceFromKafkaRecord(OrderDto orderDto){
        return Invoice.builder()
                .customerId(orderDto.getCustomerId())
                .orderId(orderDto.getOrderId())
                .invoiceDate(new Date())
                .totalAmount(orderDto.getTotalAmount())
                .build();
    }
}
