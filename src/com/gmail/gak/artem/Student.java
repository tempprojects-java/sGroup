package com.gmail.gak.artem;

public class Student extends Human {

	private String moniker;
	private double gpa;
	private int truancies;

	public Student(String name, String surname, Sex sex) {
		super(name, surname, sex);
	}

	public Student() {
		super();
	}

	@Override
	public StringBuilder getInfo() {
		StringBuilder sb = super.getInfo();
		sb.append("Moniker: " + moniker + "\n");
		sb.append("GPA: " + gpa + "\n");
		sb.append("Truancies: " + truancies + "\n");

		return sb;
	}

	public String getMoniker() {
		return moniker;
	}

	public void setMoniker(String moniker) {
		if (moniker == null) {
			throw new NullPointerException();
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

	public int compareTo(Student student) {
		if(student == null) {
			return -1;
		}
		return super.getFullName().compareTo(student.getFullName());
	}
	
	@Override
	public String toString() {
		return "Student [name=" + super.getName() + ", surname=" + super.getSurname() + ", gender=" + super.getSex()
				+ ", moniker=" + moniker + ", gpa=" + gpa + ", truancies=" + truancies + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Student other = (Student) obj;
		if (Double.doubleToLongBits(gpa) != Double.doubleToLongBits(other.gpa)) {
			return false;
		}
		if (moniker == null) {
			if (other.moniker != null) {
				return false;
			}
		} else if (!moniker.equals(other.moniker)) {
			return false;
		}
		if (truancies != other.truancies) {
			return false;
		}
		if(!super.getName().equals(other.getName()) ) {
			return false;
		}
		if(!super.getSurname().equals(other.getSurname())) {
			return false;
		}
		if(!super.getSex().equals(other.getSex())) {
			return false;
		}
		return true;
	}

}
