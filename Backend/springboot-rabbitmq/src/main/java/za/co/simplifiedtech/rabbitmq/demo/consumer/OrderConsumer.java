package za.co.simplifiedtech.rabbitmq.demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import za.co.simplifiedtech.rabbitmq.demo.config.MessagingConfig;
import za.co.simplifiedtech.rabbitmq.demo.dto.OrderStatus;

@Component
@Slf4j
public class OrderConsumer {
    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        log.info("Message Received From Queue : " + orderStatus);
    }
}
