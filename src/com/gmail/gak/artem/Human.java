package com.gmail.gak.artem;

import java.util.Scanner;

public class Human {

	private String name;
	private String surname;
	private Sex sex;
	private int age;

	public Human(Scanner sc) {
		super();

		System.out.println("Name:");
		this.name = sc.nextLine();

		System.out.println("Surname:");
		this.surname = sc.nextLine();

		System.out.println("Sex - press (0) Male, (1) Fmale:");
		this.sex = Utility.inputSexValue(sc);

		System.out.println("Age:");
		this.age = Utility.inputIntValue(sc);
	}

	public Human(String name, String surname, Sex sex, int age) {
		super();

		if (name == null || surname == null || sex == null) {
			throw new IllegalArgumentException();
		}

		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.age = age;
	}

	public Human() {
		super();
	}

	public String getInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: " + name + " " + surname + "\n");
		sb.append("Sex: " + sex + "\n");
		sb.append("Age: " + age + "\n");
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if (surname == null) {
			throw new IllegalArgumentException();
		}
		this.surname = surname;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		if (sex == null) {
			throw new IllegalArgumentException();
		}
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFullName() {
		return name + " " + surname;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", surname=" + surname + ", sex=" + sex + "]";
	}	
}
