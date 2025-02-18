package com.myproject.order.graylog;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.dto.LogMessageDTO;
import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.SchemaMetadata;
import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.rest.exceptions.RestClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.print.attribute.standard.PrinterURI;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
@Slf4j
public class GraylogProducer {

    @Value("${spring.kafka.properties.schema.registry.url}")
    private String schemaRegistryUrl;
    @Value("${spring.kafka.properties.schema.registry.cache-capacity}")
    private Integer schemaRegistryCacheCapacity;
    @Value("${spring.kafka.topic.graylog}")
    private String kafkaTopicGraylog;
    @Value("${spring.application.name}")
    private String facility;
    @Value("${spring.application.facility-num}")
    private Integer facilityNum;
    private final KafkaTemplate<String, Object> kafka;
    private final ModelMapper modelMapper;

    public void sendLogMessage(String source, String message, Integer logLevel) {
        Map<String, Object> logMessage = new HashMap<>();
        logMessage.put("source", source);
        logMessage.put("message", message);
        logMessage.put("logLevel", logLevel);
        ProducerRecord<String,Object> record = new ProducerRecord<>(kafkaTopicGraylog,facility,logMessage);
        kafka.send(record);
    }

}
