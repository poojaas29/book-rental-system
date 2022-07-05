package net.javaguides.brs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.brs.entity.Book;
import net.javaguides.brs.repository.BookRepository;
import net.javaguides.brs.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	
	private BookRepository bookRepository;
	
	
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	

	@Override
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	@Override
	public Book saveBook(Book book){
		return bookRepository.save(book);
	}
	
	@Override
	public Book updateBook(Book book){
		return bookRepository.save(book);
	}
	
	@Override
	public void deleteBookById(Long id){
		bookRepository.deleteById(id);
		
	}
	
	@Override
	public Book getBookById(Long id) {
		return bookRepository.findById(id).get();
	
	
}

}
