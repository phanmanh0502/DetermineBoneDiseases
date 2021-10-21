package net.codejava.service;

import java.util.List;

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
		return symptomRepo.findById(id).get();
	}
	
	public void delete(int id) {
		symptomRepo.deleteById(id);
	}
}
