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
@Table(name = "disease")
public class Disease {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name; // tên bệnh
	
	@Column(name = "cure_method")
	private String cureMedthod; // phương pháp chữa bệnh
	
	@Transient
	private double percentage; // tỷ lệ phần trăm mắc bệnh
	
	@OneToMany(mappedBy = "disease")
	private List<Weight> listWeight;
	
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

	public String getCureMedthod() {
		return cureMedthod;
	}

	public void setCureMedthod(String cureMedthod) {
		this.cureMedthod = cureMedthod;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	
	public List<Weight> getListWeight() {
		return listWeight;
	}

	public void setListWeight(List<Weight> listWeight) {
		this.listWeight = listWeight;
	}

	public Disease() {
		super();
	}

	public Disease(Integer id, String name, String cureMedthod, double percentage, List<Weight> listWeight) {
		super();
		this.id = id;
		this.name = name;
		this.cureMedthod = cureMedthod;
		this.percentage = percentage;
		this.listWeight = listWeight;
	}

}
