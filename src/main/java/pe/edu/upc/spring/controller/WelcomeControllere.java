package pe.edu.upc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class WelcomeControllere {
	
	@GetMapping("/welcome")
	public String irPaginaBienvenida() {
		return "home";
	}
	
	/*
public String irPaginaBienvenida() {
	return "home";}*/

}
