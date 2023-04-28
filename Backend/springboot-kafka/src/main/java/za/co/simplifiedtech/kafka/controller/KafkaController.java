package za.co.simplifiedtech.kafka.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.co.simplifiedtech.kafka.publisher.KafkaProducer;

@RestController
@RequestMapping(value = "v1/api/kafka")
@Slf4j
public class KafkaController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/message")
    public String sendMessage(@RequestParam("message") String message) {
        log.info("Started Rest Controller For The Message : {}", message);
        kafkaProducer.sendMessage("my-topic", message);
        log.info("Completed Rest Controller For The Message : {}", message);
        return "Successfully Published The Message";
    }
}
