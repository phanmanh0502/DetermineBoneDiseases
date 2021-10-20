package net.codejava.cbr;

import java.util.ArrayList;
import java.util.List;

import net.codejava.entity.Disease;
import net.codejava.entity.Symptom;

public class CBR {
	// thuật toán này cần phải dùng set mới ra được
	// mỗi lần gặp cái mới cho vào set
	public List<Disease> cbrAlg(List<Symptom> listSymptom) {
		List<Disease> listDisease = new ArrayList<Disease>();
		listDisease.add(new Disease(1, "đau tay", "băng bó tay", 80, null));
		listDisease.add(new Disease(1, "đau chân", "băng bó chân", 10.98, null));
		return listDisease;
	}
}
