package net.javaguides.brs.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.javaguides.brs.entity.OrderedBook;
import net.javaguides.brs.service.OrderedBookService;

@Controller
public class OrderedBookController {

	private OrderedBookService orderedBookService;

	public OrderedBookController(OrderedBookService orderedBookService) {
		this.orderedBookService = orderedBookService;
	}

	@GetMapping("/ordered_book/add/{id}")
	public String addBookToOrder(@PathVariable Long id, Model model) {
		
		// Step 1 : Add book to order
		orderedBookService.addBookToOrder(id);

		return "redirect:/ordered_book";

	}
	
	@GetMapping("/ordered_book")
	public String addBookToOrder(Model model) {
		
		// Step 2: Get all ordered books
		List<OrderedBook> orderedBooks = orderedBookService.getOrderedbooks();

		model.addAttribute("orderedBooks", orderedBooks);
		Long total = orderedBookService.sumRent();
		model.addAttribute("total", total);
		return "ordered_book";
		

	}

	@GetMapping("/ordered_book/delete/{id}")
	public String deleteOrderedBook(@PathVariable Long id) {
		orderedBookService.deleteOrderedBook(id);
		return "redirect:/ordered_book";

	}
	


}
