package com.bosung.todolist.web.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todolist")
public class PageController {
	
	@GetMapping("/index")
	public String loadindex() {
		return "index";
	}
}
