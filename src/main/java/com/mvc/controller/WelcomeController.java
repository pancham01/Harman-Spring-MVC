package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	
	@RequestMapping("/login")
	public String welcome()
	{
		System.out.println("WelcomeController.welcome()");
		return "home.jsp";
	}

}
