package net.codejava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SymptomController {
	@RequestMapping("/symptom")
	public String viewHomePage() {
		return "symptom/symptom";
	}
}
