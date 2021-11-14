package net.codejava.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import net.codejava.entity.Symptom;
import net.codejava.model.SymptomModel;
import net.codejava.repository.SymptomRepository;

@Service
@Transactional
public class SymptomService {
	@Autowired
	private SymptomRepository symptomRepo;
	
	public List<Symptom> listAll(){
		return symptomRepo.findAll();
	}
	
	public void save(Symptom symptom) {
		symptomRepo.save(symptom);
	}
	
	public Symptom get(int id) {
		return symptomRepo.findById(id).orElse(null);
	}
	
	public void delete(int id) {
		symptomRepo.deleteById(id);
	}

	public List<Symptom> addSymptomInView(Model model, SymptomModel symptomModel, HttpServletRequest request) {
		boolean validate = validateSymtom(model, symptomModel, request);
		List<Symptom> listSymptom = (List<Symptom>) request.getSession().getAttribute("listSymptom");
		request.getSession().setAttribute("listSymptom", listSymptom);
		if (validate == false) {
			return listSymptom;
		}

		Optional<Symptom> st = symptomRepo.findByName(symptomModel.getName());
		if (st.isPresent()) {
			st.get().setSimilarity(symptomModel.getSimilarity());
		}
		boolean hasSymptomInList = false;
		for (Symptom symp : listSymptom) {

			if (symp.getId().equals(st.get().getId())) {
				symp.setSimilarity(st.get().getSimilarity());
				hasSymptomInList = true;
			}
		}
		if (!hasSymptomInList) {
			listSymptom.add(st.get());
		}

		return listSymptom;
	}

	private boolean validateSymtom(Model model, SymptomModel symptom, HttpServletRequest request) {
		String messageError;
		if (symptom == null) {
			messageError = "Vui lòng chọn 1 triệu chứng";
			model.addAttribute("nameSymptom", messageError);
			return false;
		}
		Optional<Symptom> symptomExits = symptomRepo.findByName(symptom.getName());
		if (!symptomExits.isPresent()) {
			messageError = "Triệu chứng không tồn tại";
			model.addAttribute("nameSymptomError", messageError);
			return false;
		}

		if (symptom.getSimilarity() == 0 || symptom.getSimilarity() > 1) {
			messageError = "Vui lòng nhập triệu chứng trong khoảng từ 0 - 1 ";
			model.addAttribute("similarityError", messageError);
			return false;
		}

		return true;
	}

}
