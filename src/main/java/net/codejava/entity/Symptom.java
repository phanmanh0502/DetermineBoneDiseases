package net.codejava.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "symptom")
public class Symptom {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name; // tên triệu chứng
	
	@Transient
	private double similarity; // độ tương đồng
	
	@OneToMany(mappedBy = "symptom")
	List<Weight> listWeight;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSimilarity() {
		return similarity;
	}

	public void setSimilarity(double similarity) {
		this.similarity = similarity;
	}

	public List<Weight> getListWeight() {
		return listWeight;
	}

	public void setListWeight(List<Weight> listWeight) {
		this.listWeight = listWeight;
	}

	public Symptom() {
		super();
	}

	public Symptom(Integer id, String name, double similarity, List<Weight> listWeight) {
		super();
		this.id = id;
		this.name = name;
		this.similarity = similarity;
		this.listWeight = listWeight;
	}
	
}
