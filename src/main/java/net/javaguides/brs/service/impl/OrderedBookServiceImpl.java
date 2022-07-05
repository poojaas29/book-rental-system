package net.javaguides.brs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.brs.entity.Book;
import net.javaguides.brs.entity.Order;
import net.javaguides.brs.entity.OrderedBook;
import net.javaguides.brs.enums.OrderStatus;
import net.javaguides.brs.repository.OrderedBookRepository;
import net.javaguides.brs.service.BookService;
import net.javaguides.brs.service.OrderService;
import net.javaguides.brs.service.OrderedBookService;

@Service
public class OrderedBookServiceImpl implements OrderedBookService {

	private OrderedBookRepository orderedBookRepository;

	private OrderService orderService;

	private BookService bookService;

	public OrderedBookServiceImpl(OrderedBookRepository orderedBookRepository, OrderService orderService,
			BookService bookService) {
		super();
		this.orderedBookRepository = orderedBookRepository;
		this.orderService = orderService;
		this.bookService = bookService;
	}

	@Override
	public void deleteOrderedBook(Long orderedBookId) {
		orderedBookRepository.deleteById(orderedBookId);

	}

	@Override
	public OrderedBook addBookToOrder(Long bookId) {
		Order order = orderService.getOrderByStatus(OrderStatus.IN_PROCESS.getStatus());

		if (order == null) {
			order = new Order();
			order.setStatus(OrderStatus.IN_PROCESS.getStatus());
			order = orderService.save(order);
		}

		Book book = bookService.getBookById(bookId);

		OrderedBook orderedBook = new OrderedBook();
		orderedBook.setOrder(order);
		orderedBook.setBook(book);

		return orderedBookRepository.save(orderedBook);

	}
	
	@Override
	public Long sumRent() {
		return orderedBookRepository.sumRent();
	}

	@Override
	public List<OrderedBook> getOrderedbooks() {
		Order order = orderService.getOrderByStatus(OrderStatus.IN_PROCESS.getStatus());
		return orderedBookRepository.findByOrder(order);
	}

}
