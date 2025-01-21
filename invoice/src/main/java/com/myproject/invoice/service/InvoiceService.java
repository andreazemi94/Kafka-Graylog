package com.myproject.invoice.service;

import com.myproject.dto.OrderDto;
import com.myproject.invoice.model.Invoice;

public interface InvoiceService {

    Invoice save(Invoice invoice);

    void consumeKafkaRecord(OrderDto orderDto);
}
