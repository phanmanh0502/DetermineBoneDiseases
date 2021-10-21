
package net.codejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.entity.Weight;
import net.codejava.service.WeightService;

@Controller
public class WeightController {
	@Autowired
	private WeightService weightService;
	
	@RequestMapping("/weight")
	public String viewHomePage(Model model) {
		List<Weight> listWeights = weightService.listAll();
		model.addAttribute("listWeights", listWeights);
		return "weight/weight";
	}
	
	@RequestMapping("/weight_new")
	public String showNewWeightPage(Model model) {
		Weight weight = new Weight();
		model.addAttribute("weight", weight);
		return "weight/weight_new";
	}

	@RequestMapping(value = "/weight_save", method = RequestMethod.POST)
	public String saveWeight(@ModelAttribute("weight") Weight weight) {
		weightService.save(weight);
		return "redirect:/weight/weight";
	}

	@RequestMapping("/weight_edit/{id}")
	public ModelAndView showEditWeightPage(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("weight/weight_edit");
		Weight weight = weightService.get(Integer.valueOf(id));
		mav.addObject("weight", weight);
		return mav;
	}

	@RequestMapping("/weight_delete/{id}")
	public String deleteWeight(@PathVariable(name = "id") String id) {
		weightService.delete(Integer.valueOf(id));
		return "redirect:/weight/weight";
	}
}
