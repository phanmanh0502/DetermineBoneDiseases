package net.codejava.controller;

import java.util.Collections;
import java.util.List;

import net.codejava.entity.Weight;
import net.codejava.service.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.entity.Symptom;
import net.codejava.service.SymptomService;

@Controller
public class SymptomController {
	@Autowired
	private SymptomService symptomService;

	@Autowired
	private WeightService weightService;

	@RequestMapping("/symptom")
	public String viewHomePage(Model model) {
		List<Symptom> listSymptoms = symptomService.listAll();
		model.addAttribute("listSymptoms", listSymptoms);
		return "symptom/symptom";
	}

	@RequestMapping("/symptom_new")
	public String showNewSymptomPage(Model model) {
		Symptom symptom = new Symptom();
		model.addAttribute("symptom", symptom);
		return "symptom/symptom_new";
	}

	@RequestMapping(value = "/symptom_save", method = RequestMethod.POST)
	public String saveSymptom(@ModelAttribute("symptom") Symptom symptom) {
		symptomService.save(symptom);
		return "redirect:/symptom";
	}

	@RequestMapping("/symptom_edit/{id}")
	public ModelAndView showEditSymptomPage(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("symptom/symptom_edit");
		Symptom symptom = symptomService.get(Integer.valueOf(id));
		mav.addObject("symptom", symptom);
		return mav;
	}

	@RequestMapping("/symptom_delete/{id}")
	public String deleteSymptom(@PathVariable(name = "id") String id) {
		symptomService.delete(Integer.valueOf(id));
		return "redirect:/symptom";
	}

	@RequestMapping("/symptom_view_weight/{id}")
	public ModelAndView loadWeightBySymptom(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("weight/weight");
		Symptom symptom = symptomService.get(Integer.valueOf(id));
		if (symptom == null) {
			mav.addObject("listWeights", Collections.emptyList());
		} else {
			mav.addObject("listWeights", symptom.getListWeight());
		}
		return mav;
	}
}
