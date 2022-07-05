package net.javaguides.brs.service;

import java.util.List;

import net.javaguides.brs.entity.Order;
import net.javaguides.brs.entity.OrderedBook;

public interface OrderedBookService {
	
	void deleteOrderedBook(Long orderedBookId);
	
	OrderedBook addBookToOrder(Long bookId);
	
	List<OrderedBook> getOrderedbooks();
	

	public Long sumRent();

}
