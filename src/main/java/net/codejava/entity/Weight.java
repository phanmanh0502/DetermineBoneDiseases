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
	private Integer id;
	
	@Column(name = "weight")
	private double weight; // trọng số của triệu chứng đối với bệnh

	@Column(name = "id_symptom")
	private Integer idSymptom;
	
	@ManyToOne
    @JoinColumn(name = "id_symptom", insertable=false, updatable=false)
	private Symptom symptom;
	
	@Column(name = "id_disease")
	private Integer idDisease;
	
	@ManyToOne
    @JoinColumn(name = "id_disease", insertable=false, updatable=false)
	private Disease disease;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getIdSymptom() {
		return idSymptom;
	}

	public void setIdSymptom(Integer idSymptom) {
		this.idSymptom = idSymptom;
	}

	public Integer getIdDisease() {
		return idDisease;
	}

	public void setIdDisease(Integer idDisease) {
		this.idDisease = idDisease;
	}

	public Weight(Integer id, double weight, Integer idSymptom, Symptom symptom, Integer idDisease, Disease disease) {
		super();
		this.id = id;
		this.weight = weight;
		this.idSymptom = idSymptom;
		this.symptom = symptom;
		this.idDisease = idDisease;
		this.disease = disease;
	}

	public Weight(Integer id, double weight, Integer idSymptom, Integer idDisease) {
		super();
		this.id = id;
		this.weight = weight;
		this.idSymptom = idSymptom;
		this.idDisease = idDisease;
	}

	public Weight(Integer id, double weight, Symptom symptom, Disease disease) {
		super();
		this.id = id;
		this.weight = weight;
		this.symptom = symptom;
		this.disease = disease;
	}

	public Weight() {
		super();
	}
	
}
