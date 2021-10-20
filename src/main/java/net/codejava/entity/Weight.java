package net.codejava.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "weight")
public class Weight {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "weight")
	private double weight; // trọng số của triệu chứng đối với bệnh

	@ManyToOne
    @JoinColumn(name = "id_symptom")
	private Symptom symptom;
	
	@ManyToOne
    @JoinColumn(name = "id_disease")
	private Disease disease;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public Symptom getSymptom() {
		return symptom;
	}

	public void setSymptom(Symptom symptom) {
		this.symptom = symptom;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	public Weight(int id, double weight, Symptom symptom, Disease disease) {
		super();
		this.id = id;
		this.weight = weight;
		this.symptom = symptom;
		this.disease = disease;
	}

	public Weight() {
		super();
	}
	
	
//	@Column(name = "id_disease")
//	private int idDisease; // id bệnh
//	
//	private String diseaseName; // tên bệnh
//	
//	@Column(name = "id_symptom")
//	private int idSymptom; // id triệu chứng
//	
//	private String symptomName; // tên triệu chứng
//	
//	public int getIdDisease() {
//	return idDisease;
//}
//
//public void setIdDisease(int idDisease) {
//	this.idDisease = idDisease;
//}
//
//public int getIdSymptom() {
//	return idSymptom;
//}
//
//public void setIdSymptom(int idSymptom) {
//	this.idSymptom = idSymptom;
//}
//	
//	public String getDiseaseName() {
//		return diseaseName;
//	}
//
//	public void setDiseaseName(String diseaseName) {
//		this.diseaseName = diseaseName;
//	}
//
//	public String getSymptomName() {
//		return symptomName;
//	}
//
//	public void setSymptomName(String symptomName) {
//		this.symptomName = symptomName;
//	}

}
