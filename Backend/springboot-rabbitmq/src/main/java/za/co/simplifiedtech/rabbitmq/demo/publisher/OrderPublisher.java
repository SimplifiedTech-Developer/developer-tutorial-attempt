package za.co.simplifiedtech.rabbitmq.demo.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import za.co.simplifiedtech.rabbitmq.demo.config.MessagingConfig;
import za.co.simplifiedtech.rabbitmq.demo.dto.Order;
import za.co.simplifiedtech.rabbitmq.demo.dto.OrderStatus;
import za.co.simplifiedtech.rabbitmq.demo.enums.Status;

import java.util.UUID;

@RestController
@RequestMapping("/v1/api/order")
@Slf4j
public class OrderPublisher {
    @Autowired
    private RabbitTemplate template;
    @Value("${order.exchange}")
    private static final String EXCHANGE = "";
    @Value("${order.routing.key}")
    private static final String ROUTING_KEY = "";

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
        log.info("Started Publishing Message : {}", order.toString());
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order, Status.IN_PROGRESS, "Order Was Placed Successfully At ".concat(restaurantName));
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);
        log.info("Completed Publishing Message : {}", order);
        return "Success !!";
    }
}
