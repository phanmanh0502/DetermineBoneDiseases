package net.codejava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.codejava.service.SymptomService;

@Controller
public class SymptomController {
	@Autowired
	private SymptomService symptomService;
	
	@RequestMapping("/symptom")
	public String viewHomePage(Model model) {
		return "symptom/symptom";
	}
}
