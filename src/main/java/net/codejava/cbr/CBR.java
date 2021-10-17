package net.codejava.cbr;

import java.util.ArrayList;
import java.util.List;

import net.codejava.entity.Disease;
import net.codejava.entity.Symptom;

public class CBR {
	public List<Disease> cbrAlg(List<Symptom> listSymptom) {
		List<Disease> listDisease = new ArrayList<Disease>();
		listDisease.add(new Disease(1, "đau tay", "băng bó tay", 80));
		listDisease.add(new Disease(1, "đau chân", "băng bó chân", 10.98));
		return listDisease;
	}
}
