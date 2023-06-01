package za.co.simplifiedtech.camel.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import za.co.simplifiedtech.camel.api.dto.OrderDTO;

@Service
public class OrderService {
	private List<OrderDTO> list = new ArrayList<>();
	@PostConstruct
	public void initDB() {
		list.add(new OrderDTO(67, "Mobile", 5000));
		list.add(new OrderDTO(89, "Book", 400));
		list.add(new OrderDTO(45, "AC", 15000));
		list.add(new OrderDTO(67, "Shoes", 4000));
	}
	public OrderDTO addOrder(OrderDTO orderDTO) {
		list.add(orderDTO);
		return orderDTO;
	}
	public List<OrderDTO> getOrders() {
		return list;
	}
}
