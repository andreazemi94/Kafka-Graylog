package com.myproject.invoice.kafka;

import com.myproject.dto.OrderDto;
import com.myproject.invoice.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final InvoiceService invoiceService;

    @KafkaListener(
            topics = "${spring.kafka.topic.order}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderDto orderDto) {
        invoiceService.consumeKafkaRecord(orderDto);
    }
}
