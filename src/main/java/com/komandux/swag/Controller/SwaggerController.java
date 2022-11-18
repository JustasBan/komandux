package com.komandux.swag.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {

	@GetMapping("/sayHello")
	public String sayHello() {
		return "Hello...";
	}
}
