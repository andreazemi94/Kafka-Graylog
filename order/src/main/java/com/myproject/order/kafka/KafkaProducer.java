package com.myproject.order.kafka;

import com.myproject.order.graylog.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecord;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.Config;
import org.apache.kafka.clients.admin.DescribeConfigsResult;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.config.ConfigResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@Service
@Slf4j
public class KafkaProducer {

    @Value("${spring.kafka.topic.order}")
    private String kafkaTopic;
    @Value("${spring.kafka.properties.schema.registry.url}")
    private String schemaRegistryUrl;
    @Value("${spring.kafka.properties.schema.registry.cache-capacity}")
    private Integer schemaRegistryCacheCapacity;
    private final KafkaTemplate<String, Object> kafka;
    private final GraylogProducer graylogProducer;
    private final ModelMapper modelMapper;

    public <T extends SpecificRecord> void sendMessage(String source, String messageKey, Object object, Type destinationType ) {
        ProducerRecord<String,Object> record = new ProducerRecord<>(kafkaTopic,messageKey,object);
        kafka.send(record)
                .whenCompleteAsync((topic,error)->
                        logMessage(error, source, modelMapper.map(object, destinationType)));
    }

    private <D> void logMessage(Throwable error, String source, D object){
        String message = (Objects.isNull(error))
                ? String.format("Send %s %s to topic %s", object.getClass().getSimpleName(), object, kafkaTopic)
                : String.format("Error to send %s: %s", object.getClass().getSimpleName(),error.getMessage());
        Integer logLevel = (Objects.isNull(error)) ? 1 : 5;
        graylogProducer.sendLogMessage(source, message, logLevel);
    }

}
