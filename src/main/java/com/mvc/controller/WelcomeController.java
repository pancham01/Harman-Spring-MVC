package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.model.User;

@Controller
public class WelcomeController {

	@GetMapping(value = "/")
	public String welcome() {
		System.out.println("WelcomeController.welcome()");
		return "home";
	}

	@GetMapping("sign-up")
	public String form() {
		System.out.println("WelcomeController.form()");

		return "form";
	}

	@PostMapping("/submitForm")
	public String signUp(@RequestParam(name = "userName") String name, @RequestParam(name = "email") String email,
			Model model) {

		User u = new User();
		u.setId(2);
		u.setUserName(name);
		u.setEmail(email);
		
		model.addAttribute("user", u);

		System.out.println("WelcomeController.signUp()");
		
		return "result";
	}

	@PostMapping("/submitForm")
	public String signUpWithModelAttribute(@ModelAttribute User user, Model model) {
		System.out.println("Hello " + " Welcome............");
		user.setId(1);
		model.addAttribute("user", user);
		return "result";
	}

}
