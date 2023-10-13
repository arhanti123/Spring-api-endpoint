package com.example.springapiidemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome {
@GetMapping("/Welcome")
public String welcome(){
	return "Welcome to springboot";
}
}
