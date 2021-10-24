package net.codejava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.codejava.service.DetermineService;

@Controller
public class DetermineController {
	@Autowired
	private DetermineService determineService;
	
	@RequestMapping("/determine")
	public String viewHomePage() {
		return "determine/determine";
	}
}
