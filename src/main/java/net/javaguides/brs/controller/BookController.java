package net.javaguides.brs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.brs.entity.Book;
import net.javaguides.brs.service.BookService;

@Controller
public class BookController {

	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	
	@GetMapping("/books")
	public String listBooks(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "books";

	}

	@PostMapping("/books")
	public String saveBook(@ModelAttribute("books") Book book) {
		bookService.saveBook(book);
		return "redirect:/books";
	}

	@GetMapping("/books/add_book")
	public String createBookForm(Model model) {

		Book book = new Book();
		model.addAttribute("book", book);
		return "add_book";

	}

	@GetMapping("/books/edit/{id}")
	public String editBookForm(@PathVariable Long id, Model model) {
		model.addAttribute("book", bookService.getBookById(id));
		return "edit_book";

	}

	@PostMapping("/books/{id}")
	public String updateBook(@PathVariable Long id, @ModelAttribute("book") Book book, Model model) {

		Book existingBook = bookService.getBookById(id);
		existingBook.setId(id);
		existingBook.setTitle(book.getTitle());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setRent(book.getRent());
		existingBook.setImage(book.getImage());
		existingBook.setIsRented(book.getIsRented());

		bookService.updateBook(existingBook);
		return "redirect:/books";
	}

	@GetMapping("/books/{id}")
	public String deleteBook(@PathVariable Long id) {
		bookService.deleteBookById(id);
		return "redirect:/books";

	}

}
