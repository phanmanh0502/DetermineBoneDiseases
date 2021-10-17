package net.codejava.entity;

public class Disease {
	private int id;
	
	private String name; // tên bệnh
	
	private String cureMedthod; // phương pháp chữa bệnh
	
	private double percentage; // tỷ lệ phần trăm mắc bệnh

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiseaseString() {
		return name;
	}

	public void setDiseaseString(String name) {
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

	public Disease(int id, String name, String cureMedthod, double percentage) {
		super();
		this.id = id;
		this.name = name;
		this.cureMedthod = cureMedthod;
		this.percentage = percentage;
	}

	public Disease() {
		super();
	}
	
	
}
