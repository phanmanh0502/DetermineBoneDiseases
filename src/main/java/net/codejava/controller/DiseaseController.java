package net.codejava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.entity.Disease;
import net.codejava.service.DiseaseService;

@Controller
public class DiseaseController {
	@Autowired
	private DiseaseService diseaseService;
	
	@RequestMapping("/disease")
	public String viewHomePage() {
		return "disease/disease";
	}
	
	@RequestMapping("/disease_new")
	public String showNewDiseasePage(Model model) {
		Disease disease = new Disease();
		model.addAttribute("disease", disease);
		return "disease_new";
	}
	
	@RequestMapping(value = "/disease_save", method = RequestMethod.POST)
	public String saveDisease(@ModelAttribute("disease") Disease disease) {
//		diseaseService.save(disease);
		return "redirect:/disease";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditDiseasePage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("disease_edit");
//		Disease disease = diseaseService.get(id);
//		mav.addObject("disease", disease);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteDisease(@PathVariable(name = "id") int id) {
//		diseaseService.delete(id);
		return "redirect:/disease";		
	}
}
