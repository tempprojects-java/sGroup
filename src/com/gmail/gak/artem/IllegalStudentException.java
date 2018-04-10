package com.gmail.gak.artem;

public class IllegalStudentException extends Exception {
	@Override
	public String getMessage() {
		return "Student without a record card is not a student";
	}
}
