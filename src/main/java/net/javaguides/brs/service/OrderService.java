package net.javaguides.brs.service;

import net.javaguides.brs.entity.Order;

public interface OrderService {
	
	Order getOrderByStatus(String status);
	
	Order save(Order order);

}
