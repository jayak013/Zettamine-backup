package com.excp;

public class Applicant {
	private int id;
	private String name;
	private int age;
	private String nationality;
	
	public Applicant(int id, String name, int age, String nationality) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.nationality = nationality;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "Applicant [id=" + id + ", name=" + name + ", age=" + age + ", nationality=" + nationality + "]";
	}
	
	
}
