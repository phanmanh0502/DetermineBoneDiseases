package net.codejava.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.entity.Disease;
import net.codejava.entity.Symptom;
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

	// thuật toán này cần phải dùng set mới ra được
	// mỗi lần gặp cái mới cho vào set
	public List<Disease> cbrAlg(List<Symptom> listSymptom) {
		List<Disease> listDisease = new ArrayList<Disease>();
		listDisease.add(new Disease(1, "đau tay", "băng bó tay", 80));
		listDisease.add(new Disease(1, "đau chân", "băng bó chân", 10.98));
		return listDisease;
	}
}
