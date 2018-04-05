package com.gmail.gak.artem;

public class Human {

	private String name;
	private String surname;
	private Sex sex;

	public Human(String name, String surname, Sex sex) {
		super();

		if (name == null || surname == null || sex == null) {
			throw new NullPointerException();
		}

		this.name = name;
		this.surname = surname;
		this.sex = sex;
	}

	public Human() {
		super();
	}
	
	public StringBuilder getInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: " + name + " " + surname + "\n");
		sb.append("Sex: " + sex + "\n");
		return sb;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			throw new NullPointerException();
		}
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if (surname == null) {
			throw new NullPointerException();
		}
		this.surname = surname;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		if (sex == null) {
			throw new NullPointerException();
		}
		this.sex = sex;
	}

	public String getFullName() {
		return name + " " + surname;
	}
	
	@Override
	public String toString() {
		return "Human [name=" + name + ", surname=" + surname + ", sex=" + sex + "]";
	}

}
