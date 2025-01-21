package com.myproject.graylogpub.kafka;

import com.myproject.graylogpub.graylog.*;
import io.confluent.kafka.schemaregistry.client.rest.exceptions.RestClientException;
import lombok.RequiredArgsConstructor;
import org.apache.avro.specific.SpecificRecord;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ModelMapper modelMapper;
    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaServer;
    private final KafkaProducer kafkaProducer;

    @KafkaListener(
            topics = "${spring.kafka.topic.graylog}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public <T extends SpecificRecord> void consume(T specificRecord) throws RestClientException, IOException {
        LogMessage logMessage = modelMapper.map(specificRecord, LogMessage.class);
        logMessage.setInfoLevel(LogLevel.fromLevel(logMessage.getLevel()).name());
        kafkaProducer.sendMessage(kafkaServer, logMessage.getFacility(), logMessage);
    }
}
