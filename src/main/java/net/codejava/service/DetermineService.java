package net.codejava.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codejava.entity.Disease;
import net.codejava.entity.Symptom;
import net.codejava.entity.Weight;

@Service
@Transactional
public class DetermineService {
	@Autowired
	private DiseaseService diseaseService;

	@Autowired
	private WeightService weightService;

	/**
	 * Function chẩn đoán bệnh
	 * param: listSymptom danh sách triệu chứng và độ tương đồng, return: listDisease danh sách bệnh và phần trăm mắc mỗi bệnh
	 */
	public List<Disease> cbrAlg(List<Symptom> listSymptom) {
		// Truy vấn list bệnh có khả năng mắc trong các triệu chứng đã nhập
		Map<Integer, Symptom> mapSymptomIdAndSymptom = new HashMap<>();
		listSymptom.forEach(symptom -> mapSymptomIdAndSymptom.put(symptom.getId(), symptom));
		List<Integer> listDiseaseId = weightService.getListDiseaseIdBySymptomIdIn(mapSymptomIdAndSymptom.keySet());
		List<Disease> listDisease = diseaseService.getAllByIdIn(listDiseaseId);
		// Tính toán khả năng mắc mỗi bệnh dựa vào thuật toán cbr
		return listDisease.stream().map(disease -> {
			double percentage = 0;
			List<Weight> weights = disease.getListWeight();
			double sumWeightOfSymptom = weights.stream().mapToDouble(Weight::getWeightOfSymptom).sum();

			for (Weight weight : weights) {
				Integer symptomId = weight.getIdSymptom();
				if (mapSymptomIdAndSymptom.containsKey(symptomId)) {
					Symptom symptom = mapSymptomIdAndSymptom.get(symptomId);
					percentage += weight.getWeightOfSymptom() * symptom.getSimilarity() / sumWeightOfSymptom;
				}
			}
			percentage *= 100;
			DecimalFormat f = new DecimalFormat("##.00");
			percentage = Double.parseDouble(f.format(percentage));
			disease.setPercentage(percentage);
			return disease;
		// Sắp xếp phần trăm mắc bệnh
		}).sorted((o1, o2) -> {
			if (o1.getPercentage() < o2.getPercentage())
				return 1;
			if (o1.getPercentage() > o2.getPercentage())
				return -1;
			return 0;
		}).collect(Collectors.toList());
	}
}
