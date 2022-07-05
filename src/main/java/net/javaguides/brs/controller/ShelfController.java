package net.javaguides.brs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.javaguides.brs.service.ShelfService;

@Controller
public class ShelfController {
	
	
	private ShelfService shelfService;
	
	
	public ShelfController(ShelfService shelfService) {
		this.shelfService = shelfService;
	}


	@GetMapping("/shelf/checkout/{id}")
	public String placeOrder(@PathVariable Long id, Model model) {
		
	shelfService.placeOrder(id);
		
		return "redirect:shelf";
		
	}

}
