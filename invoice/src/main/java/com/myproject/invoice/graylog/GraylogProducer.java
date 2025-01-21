package com.myproject.invoice.graylog;

import com.myproject.dto.LogMessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

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
    private final KafkaTemplate<String, LogMessageDTO> kafka;

    public void sendLogMessage(String source, String message, Integer logLevel) {
        kafka.send(kafkaTopicGraylog, facility, buildMessage(source,message,logLevel));
    }

    private LogMessageDTO buildMessage(String source, String message, Integer logLevel){
        return LogMessageDTO.newBuilder()
                .setFacility(facility)
                .setSource(source)
                .setMessage(message)
                .setInfoLevel(String.valueOf(logLevel))
                .setLevel(logLevel)
                .build();
    }
}
