package com.loginapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
	@RequestMapping("/")
	public String home() {
		return "<h1>Welcome to Launch page</h1>";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "<h1>Welcome to Admin page</h1>";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "<h1>Welcome to User page</h1>";
	}

}
