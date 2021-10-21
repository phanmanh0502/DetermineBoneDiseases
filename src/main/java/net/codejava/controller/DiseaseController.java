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

import net.codejava.entity.Disease;
import net.codejava.service.DiseaseService;

@Controller
public class DiseaseController {
	@Autowired
	private DiseaseService diseaseService;

	@RequestMapping("/disease")
	public String viewHomePage(Model model) {
		List<Disease> listDeseases = diseaseService.listAll();
		model.addAttribute("listDiseases", listDeseases);
		return "disease/disease";
	}

	@RequestMapping("/disease_new")
	public String showNewDiseasePage(Model model) {
		Disease disease = new Disease();
		model.addAttribute("disease", disease);
		return "disease/disease_new";
	}

	@RequestMapping(value = "/disease_save", method = RequestMethod.POST)
	public String saveDisease(@ModelAttribute("disease") Disease disease) {
		diseaseService.save(disease);
		return "redirect:/disease/disease";
	}

	@RequestMapping("/disease_edit/{id}")
	public ModelAndView showEditDiseasePage(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("disease/disease_edit");
		Disease disease = diseaseService.get(Integer.valueOf(id));
		mav.addObject("disease", disease);
		return mav;
	}

	@RequestMapping("/disease_delete/{id}")
	public String deleteDisease(@PathVariable(name = "id") String id) {
		diseaseService.delete(Integer.valueOf(id));
		// phần xóa này Đức nhớ xóa cả các triệu chứng join với bảng này nhé
		return "redirect:/disease/disease";
	}

	// controller cho phần load trọng số nó join
	// phần này ông trả về cho tôi 1 list trọng số join theo bảng này nhé
	// đặt tên là listWeights
	@RequestMapping("/disease_view_weight/{id}")
	public String loadWeightByDisease(@PathVariable(name = "id") String id) {
		// xử lý ở đây
		return "redirect:/weight/weight";
	}
}
