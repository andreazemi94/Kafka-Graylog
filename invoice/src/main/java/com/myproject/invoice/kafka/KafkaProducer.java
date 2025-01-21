package com.myproject.invoice.kafka;

import com.myproject.invoice.graylog.GraylogProducer;
import io.confluent.kafka.schemaregistry.client.rest.exceptions.RestClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecord;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Objects;

@RequiredArgsConstructor
@Service
@Slf4j
public class KafkaProducer {

    @Value("${spring.kafka.topic.invoice}")
    private String kafkaTopic;
    @Value("${spring.kafka.properties.schema.registry.url}")
    private String schemaRegistryUrl;
    @Value("${spring.kafka.properties.schema.registry.cache-capacity}")
    private Integer schemaRegistryCacheCapacity;
    private final KafkaTemplate<String, ? super SpecificRecord> kafka;
    private final GraylogProducer graylogProducer;
    private final ModelMapper modelMapper;

    public <T extends SpecificRecord> void sendMessage(String source, String messageKey, T object, Type destinationType ) throws RestClientException, IOException {
        kafka.send(kafkaTopic, messageKey, object).whenCompleteAsync((topic,error)-> logMessage(error, source, modelMapper.map(object, destinationType)));
    }

    private <D> void logMessage(Throwable error, String source, D object){
        String message = (Objects.isNull(error))
                ? String.format("Send %s %s to topic %s", object.getClass().getSimpleName(), object, kafkaTopic)
                : String.format("Error to send %s: %s", object.getClass().getSimpleName(),error.getMessage());
        Integer logLevel = (Objects.isNull(error)) ? 1 : 5;
        graylogProducer.sendLogMessage(source, message, logLevel);
    }

}
