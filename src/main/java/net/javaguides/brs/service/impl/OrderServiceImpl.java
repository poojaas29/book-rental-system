package net.javaguides.brs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.brs.entity.Order;
import net.javaguides.brs.repository.OrderRepository;
import net.javaguides.brs.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;

	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public Order getOrderByStatus(String status) {
		List<Order> orderList = orderRepository.findByStatus(status);

		if (!orderList.isEmpty()) {
			return orderList.get(0);
		}

		return null;
	}

	@Override
	public Order save(Order order) {
		return orderRepository.save(order);
	}

}
