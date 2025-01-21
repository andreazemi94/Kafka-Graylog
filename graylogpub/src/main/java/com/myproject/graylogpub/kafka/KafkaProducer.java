package com.myproject.graylogpub.kafka;

import com.myproject.graylogpub.graylog.LogMessage;
import io.confluent.kafka.schemaregistry.client.rest.exceptions.RestClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecord;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Objects;

@RequiredArgsConstructor
@Service
@Slf4j
public class KafkaProducer {

    @Value("${spring.kafka.topic.graylog-pub}")
    private String kafkaTopic;
    @Value("${spring.kafka.properties.schema.registry.url}")
    private String schemaRegistryUrl;
    @Value("${spring.kafka.properties.schema.registry.cache-capacity}")
    private Integer schemaRegistryCacheCapacity;
    private final KafkaTemplate<String, LogMessage> kafka;
    private final ModelMapper modelMapper;

    public <T extends SpecificRecord> void sendMessage(String source, String messageKey, LogMessage logMessage ) throws RestClientException, IOException {
        kafka.send(kafkaTopic, messageKey, logMessage).whenCompleteAsync((topic,error)-> logMessage(error, source, logMessage));
    }

    private <D> void logMessage(Throwable error, String source,LogMessage logMessage) {
        if(Objects.isNull(error))
            log.info("Log message: {}published to Graylog", logMessage);
        else
            log.error("Error to publish log message {} : {}", logMessage, error.getMessage());
    }

}
