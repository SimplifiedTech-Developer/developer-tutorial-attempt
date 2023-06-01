package za.co.simplifiedtech.camel.api.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.simplifiedtech.camel.api.dto.OrderDTO;
import za.co.simplifiedtech.camel.api.service.OrderService;

@Component
public class OrderProcessor implements Processor{
	@Autowired
	private OrderService service;
	@Override
	public void process(Exchange exchange) throws Exception {
		service.addOrder(exchange.getIn().getBody(OrderDTO.class));
	}
}
