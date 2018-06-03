package com.code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/showLoginPage")
	public String loginPage() {
		return "fancy-login";
	}
	
	@GetMapping("/leaders")
	public String leader() {
		return "leaders";
	}
	
	@GetMapping("/system")
	public String managers() {
		return "managers";
	}
	
	@GetMapping("/accessHandlers")
	public String accessHandlers() {
		return "accessHandlers";
	}
}
