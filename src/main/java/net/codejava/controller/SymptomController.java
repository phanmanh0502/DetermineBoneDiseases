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

import net.codejava.entity.Symptom;
import net.codejava.service.SymptomService;

@Controller
public class SymptomController {
	@Autowired
	private SymptomService symptomService;

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
		return "redirect:/symptom/symptom";
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
		// phần xóa này Đức nhớ xóa cả các triệu chứng join với bảng này nhé
		return "redirect:/symptom/symptom";
	}

	// controller cho phần load triệu chứng nó join, thì để tôi làm cái này
	// ManhPV
	@RequestMapping("/symptom_view_weight/{id}")
	public String loadWeightBySymptom(@PathVariable(name = "id") String id) {
		// xử lý ở đây
		return "redirect:/weight/weight";
	}
}
