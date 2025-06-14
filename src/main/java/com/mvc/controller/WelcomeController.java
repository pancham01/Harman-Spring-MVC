package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class WelcomeController {

	@GetMapping(value = "/")
	public String welcome() {
		System.out.println("WelcomeController.welcome()");
		return "home";
	}

	@GetMapping("/welcome")
	@ResponseBody
	public String requestParam(@RequestParam(name = "myname", defaultValue = "Guest") String name) {
		System.out.println("WelcomeController.requestParam()");
		return "Hello! Mr. " + name + " How are you............This is V1";
	}

	@GetMapping("sign-up")
	public String form() {
		System.out.println("WelcomeController.form()");
		
		return "form";
	}
	
	
	@PostMapping("/submitForm")
	public String signUp(@RequestParam(name = "username") String name, @RequestParam(name = "email")String email,Model model) {
		System.out.println("Hello "+name+" Welcome............");
		model.addAttribute("username", name);
		model.addAttribute("email", email);
		
		return "result";
	}
	
	
	@PostMapping("/submitForm-with-servlet")
	public String servletForm(HttpServletRequest req,Model model) {
		
		String name = req.getParameter("username");
		String email = req.getParameter("email");
		System.out.println("Hello "+name+" Welcome............this is servlet");

		model.addAttribute("username", name);
		model.addAttribute("email", email);
		
		return "result";
	}

}
