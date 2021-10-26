package net.codejava.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.entity.Disease;
import net.codejava.entity.Symptom;
import net.codejava.entity.Weight;
import net.codejava.repository.DiseseRepository;
import net.codejava.repository.SymptomRepository;
import net.codejava.repository.WeightRepository;

@Service
@Transactional
public class DetermineService {
	@Autowired
	private DiseseRepository diseaseRepo;

	@Autowired
	private WeightRepository weightRepo;

	@Autowired
	private SymptomRepository symptomRepo;

	public Set<Disease> cbrAlg(List<Symptom> listSymptom) {
		// khởi tạo 1 set bệnh
		Set<Disease> setDisease = new HashSet<Disease>();
		// tìm tất cả các bệnh bằng 2 vòng for
		for (Symptom symptom : listSymptom) {
			List<Weight> listWeight = symptom.getListWeight();
			for (Weight weight : listWeight) {
				setDisease.add(weight.getDisease());
			}
		}
		// tính toán phần trăm mắc bệnh
		for (Disease disease : setDisease) {
			double sum = 0;
			for(Weight weight : disease.getListWeight()) {
				sum += weight.getWeightOfSymptom();
			}
			disease.setTotalWeight(sum);
			double numerator = 0;
			double percentage = 0;
			for (Symptom symptom : listSymptom) {
			}
			disease.setPercentage(percentage);
		}
		return setDisease;
	}
}
