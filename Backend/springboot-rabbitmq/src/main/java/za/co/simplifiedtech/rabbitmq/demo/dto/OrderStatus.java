package za.co.simplifiedtech.rabbitmq.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import za.co.simplifiedtech.rabbitmq.demo.enums.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderStatus {
    private Order order;
    private Status status;
    private String message;
}
