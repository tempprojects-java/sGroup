package com.gmail.gak.artem;

public class GroupDuplicateException extends Exception {
	@Override
	public String getMessage() {
		return "Duplicate Data Student in Group";
	}
}
