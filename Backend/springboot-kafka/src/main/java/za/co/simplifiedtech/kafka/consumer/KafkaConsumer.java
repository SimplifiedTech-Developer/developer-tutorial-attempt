package za.co.simplifiedtech.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "my-topic", groupId = "my-group-id")
    public void receiveMessage(String message) {
        log.info("Started Consuming The Message : {}", message);
        log.info("Received Message : {}", message);
        log.info("Completed Consuming The Message : {}", message);
    }
}

