package com.gmail.gak.artem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {

	public Utility() {
		super();
	}

	public static Sex inputSexValue(Scanner sc) {
		Sex result = Sex.MALE;
		boolean success = false;

		while (!success) {
			int code = inputIntValue(sc);
			if (code == 0) {
				result = Sex.MALE;
				success = true;
			} else if (code == 1) {
				result = Sex.FMALE;
				success = true;
			} else {
				System.out.println("Invalid value, try again --");
			}
		}

		return result;
	}

	public static double inputDoubleValue(Scanner sc) {
		double result = 0.0;
		boolean success = false;

		while (!success) {
			try {
				result = sc.nextDouble();
				success = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid value, try again");
				sc.next();
				success = false;
			}
		}

		return result;
	}

	public static int inputIntValue(Scanner sc) {
		int result = 0;
		boolean success = false;

		while (!success) {
			try {
				result = sc.nextInt();
				success = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid value, try again");
				sc.next();
				success = false;
			}
		}

		return result;
	}
}
