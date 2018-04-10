package com.gmail.gak.artem;

import java.util.Scanner;

public class Student extends Human {

	private String rcard;
	private String moniker;
	private double gpa;
	private int truancies;
	
	public Student(Scanner sc) {
		super(sc);
		
		sc.nextLine();
		
		System.out.println("Record Card:");
		this.rcard = sc.nextLine();
		
		System.out.println("Moniker:");
		this.moniker = sc.nextLine();
		
		System.out.println("Grade point average (GPA):");
		this.gpa = Utility.inputDoubleValue(sc);
		
		System.out.println("Count of truancies:");
		this.truancies = Utility.inputIntValue(sc);
	}

	public Student(String name, String surname, Sex sex, int age, String rcard) {
		super(name, surname, sex, age);
		
		this.rcard = rcard;
	}

	public Student() {
		super();
	}
	
	@Override
	public String getInfo() {
		StringBuilder sb = new StringBuilder(super.getInfo());
		sb.append("Record Card: " + rcard + "\n");
		sb.append("Moniker: " + moniker + "\n");
		sb.append("GPA: " + gpa + "\n");
		sb.append("Truancies: " + truancies + "\n");

		return sb.toString();
	}

	public String getMoniker() {
		return moniker;
	}

	public void setMoniker(String moniker) {
		if (moniker == null) {
			throw new IllegalArgumentException();
		}
		this.moniker = moniker;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getTruancies() {
		return truancies;
	}

	public void setTruancies(int truancies) {
		this.truancies = truancies;
	}

	public String getRcard() {
		return rcard;
	}

	public void setRcard(String rcard) {
		this.rcard = rcard;
	}

	@Override
	public String toString() {
		return "Student [name=" + super.getName() + ", surname=" + super.getSurname() + ", gender=" + super.getSex()
				+ ", age=" + super.getAge() + ", moniker=" + moniker + ", gpa=" + gpa + ", truancies=" + truancies + "]";
	}

}
