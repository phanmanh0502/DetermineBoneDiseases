package net.codejava.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.entity.Weight;
import net.codejava.repository.WeightRepository;

@Service
@Transactional
public class WeightService {
	@Autowired
	private WeightRepository weightRepo;
	
	public List<Weight> listAll(){
		return weightRepo.findAll();
	}
	
	public void save(Weight weight) {
		weightRepo.save(weight);
	}
	
	public Weight get(int id) {
		return weightRepo.findById(id).get();
	}
	
	public void delete(int id) {
		weightRepo.deleteById(id);
	}

	public List<Integer> getListDiseaseIdBySymptomIdIn(Set<Integer> listSymptomId) {
		return weightRepo.getListDiseaseIdBySymptomIdIn(listSymptomId);
	}
}
