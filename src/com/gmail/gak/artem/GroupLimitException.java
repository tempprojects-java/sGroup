package com.gmail.gak.artem;

public class GroupLimitException extends Exception {
	@Override
	public String getMessage() {
		return "Group limit exceeded";
	}
}
