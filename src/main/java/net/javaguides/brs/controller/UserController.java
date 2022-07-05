package net.javaguides.brs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.brs.service.UserService;
import net.javaguides.brs.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/signup")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}


	@GetMapping
	public String signUp(Model model) {
		model.addAttribute("user", new UserRegistrationDto());
		return "signup";
	}

	@PostMapping
	public String registerUser(@ModelAttribute("user") UserRegistrationDto registrationDto) {

		userService.save(registrationDto);

		return "redirect:/home";
	}

}
