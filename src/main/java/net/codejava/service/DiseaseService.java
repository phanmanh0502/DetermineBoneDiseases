package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.entity.Disease;
import net.codejava.repository.DiseseRepository;

@Service
@Transactional
public class DiseaseService {
	@Autowired
	private DiseseRepository diseaseRepo;
	
	public List<Disease> listAll(){
		return diseaseRepo.findAll();
	}
	
	public void save(Disease disease) {
		diseaseRepo.save(disease);
	}
	
	public Disease get(int id) {
		return diseaseRepo.findById(id).orElse(null);
	}
	
	public void delete(int id) {
		diseaseRepo.deleteById(id);
	}

	public List<Disease> getAllByIdIn(List<Integer> listDiseaseId) {
		return diseaseRepo.findAllById(listDiseaseId);
	}
}
