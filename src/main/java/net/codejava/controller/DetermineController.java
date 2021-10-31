package net.codejava.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.codejava.entity.Symptom;
import net.codejava.service.DetermineService;
import net.codejava.service.SymptomService;

@Controller
public class DetermineController {
	@Autowired
	private DetermineService determineService;
	
	@Autowired
	private SymptomService symptomService;

	@RequestMapping(value = { "/determine" }, method = RequestMethod.GET)
	public String viewHomePage(Model model, HttpServletRequest request) {
		initComboBox(model);
		List<Symptom> listSymptomSession = new ArrayList<>();
		request.getSession().setAttribute("listSymptom", listSymptomSession);
		return "determine/determine";
	}
	
	@RequestMapping(value = { "/addSymptomInView" }, method = RequestMethod.POST)
	public String addSymptomInView(Model model, @ModelAttribute("Symptom") Symptom symptom,  HttpServletRequest request) {
		initComboBox(model);
		model.addAttribute("listSymptomSession", symptomService.addSymptomInView(symptom, request));
		return "determine/determine";
	}

	@RequestMapping(value = { "/diseasePrediction" }, method = RequestMethod.POST)
	public String diseasePrediction(Model model,
			HttpServletRequest request) {
		initComboBox(model);
		List<Symptom> listSymptomSession = (List<Symptom>) request.getSession().getAttribute("listSymptom");
		model.addAttribute("listDisease", determineService.cbrAlg(listSymptomSession));
		return "determine/determine";
	}

	private void initComboBox(Model model) {
		model.addAttribute("Symptom", new Symptom());
		List<Symptom> listSymptomForComboBox = symptomService.listAll();
		model.addAttribute("listSymptom", listSymptomForComboBox);
	}
}
