package net.codejava.model;

import javax.persistence.Transient;

public class SymptomModel {

	private Integer id;

	private String name; // tên triệu chứng

	@Transient
	private double similarity; // độ tương đồng

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

	public SymptomModel() {
		super();
	}

	public SymptomModel(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public SymptomModel(Integer id, String name, double similarity) {
		super();
		this.id = id;
		this.name = name;
		this.similarity = similarity;
	}

}
