package net.codejava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DiseaseController {
	@RequestMapping("/disease")
	public String viewHomePage() {
		return "disease/disease";
	}
}
