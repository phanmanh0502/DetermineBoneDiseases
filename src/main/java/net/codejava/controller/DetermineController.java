package net.codejava.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import net.codejava.entity.Symptom;
import net.codejava.model.SymptomModel;
import net.codejava.service.DetermineService;
import net.codejava.service.SymptomService;

@Controller
public class DetermineController implements WebMvcConfigurer {
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
	public String addSymptomInView(Model model, SymptomModel symptomModel,
			HttpServletRequest request) {
		initComboBox(model);
		model.addAttribute("listSymptomSession", symptomService.addSymptomInView(model, symptomModel, request));
		return "determine/determine";
	}

	@RequestMapping(value = { "/diseasePrediction" }, method = RequestMethod.POST)
	public String diseasePrediction(Model model,
			HttpServletRequest request) {
		initComboBox(model);

		List<Symptom> listSymptomSession = (List<Symptom>) request.getSession().getAttribute("listSymptom");
		model.addAttribute("listDisease", determineService.cbrAlg(listSymptomSession));
		model.addAttribute("listSymptomSession", listSymptomSession);
		return "determine/determine";
	}

	private void initComboBox(Model model) {
		model.addAttribute("Symptom", new SymptomModel());
		List<Symptom> listSymptomForComboBox = symptomService.listAll();
		List<String> listSymptomName = listSymptomForComboBox.stream().map(sym -> sym.getName()).toList();
		model.addAttribute("listSymptom", listSymptomName);
	}

}
