package net.codejava.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.entity.Symptom;
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

	public List<Symptom> addSymptomInView(Symptom symptom, HttpServletRequest request) {

		List<Symptom> listSymptom = (List<Symptom>) request.getSession().getAttribute("listSymptom");
		request.getSession().setAttribute("listSymptom", listSymptom);
		Optional<Symptom> st = symptomRepo.findById(symptom.getId());
		if (st.isPresent()) {
			symptom.setName(st.get().getName());
		}
		listSymptom.add(symptom);

		return listSymptom;
	}

}
