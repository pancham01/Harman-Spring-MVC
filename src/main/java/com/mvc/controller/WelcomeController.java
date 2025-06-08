package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

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
		return "Hello! Mr. " + name + " How are you............";
	}

	@GetMapping("/path/{id}")
	@ResponseBody
	public String pathVar(@PathVariable("id") Long id) {

		System.out.println("WelcomeController.pathVar()");

		return "Hello! Mr. Your id is: " + id + " How are you............";
	}

	@GetMapping("/cookie")
	@ResponseBody
	public String cookie(@CookieValue("JSESSIONID") String cookieVal) {

		System.out.println("WelcomeController.cookieVal()");

		return "Hello! Your JSESSIONID is: " + cookieVal;
	}

	@GetMapping("/secondCookie")
	@ResponseBody
	public String secondCookie(@CookieValue("NewCookie") String cookieVal) {

		System.out.println("WelcomeController.cookieVal()");

		return "Hello! Your cookieValue is: " + cookieVal;
	}

	@GetMapping("/setCookie")
	public String setCookie(HttpServletResponse response) {

		System.out.println("WelcomeController.setCookie()");
		Cookie cookie = new Cookie("NewCookie", "FirstCookieObj");
		cookie.setMaxAge(30);
		response.addCookie(cookie);
		return "redirect:/secondCookie";
	}

}
