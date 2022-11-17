package com.komandux.swag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeExample {
	
	@GetMapping("/sayHello")
	public String sayHello() {
		return "Hello...";
	}
}
