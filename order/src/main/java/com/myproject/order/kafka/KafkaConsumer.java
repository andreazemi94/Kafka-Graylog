package com.myproject.order.kafka;

import com.myproject.dto.InvoiceDTO;
import com.myproject.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final OrderService orderService;

    @KafkaListener(
            topics = "${spring.kafka.topic.invoice}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(InvoiceDTO invoiceDTO) {
        orderService.consumeKafkaRecord(invoiceDTO);
    }
}
