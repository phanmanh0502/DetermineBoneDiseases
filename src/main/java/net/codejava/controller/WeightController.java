package net.codejava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.codejava.service.WeightService;

@Controller
public class WeightController {
	@Autowired
	private WeightService weightService;
	
	@RequestMapping("/weight")
	public String viewHomePage(Model model) {
		return "weight/weight";
	}
}
