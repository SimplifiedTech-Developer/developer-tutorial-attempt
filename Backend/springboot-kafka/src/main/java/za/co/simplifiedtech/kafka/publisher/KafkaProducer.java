package za.co.simplifiedtech.kafka.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
@Slf4j
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String message) {
        log.info("Started Producing The Message : {}", message);
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(topic, message);
        log.info("Completed Producing The Message : {}", message);
    }
}

