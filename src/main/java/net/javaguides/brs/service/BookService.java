package net.javaguides.brs.service;

import java.util.List;

import net.javaguides.brs.entity.Book;

public interface BookService {

	List<Book> getAllBooks();

	Book saveBook(Book book);
	
	Book updateBook(Book book);
	
	void deleteBookById(Long id);
	
	Book getBookById(Long id);

}
