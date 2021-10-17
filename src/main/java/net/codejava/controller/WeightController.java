package net.codejava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeightController {
	@RequestMapping("/weight")
	public String viewHomePage() {
		return "weight/weight";
	}
}
