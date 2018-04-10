package com.gmail.gak.artem;

public class Main {

	public static void main(String[] args) {
		
		Student sA = new Student("Gbcasds", "FDfsdfsdf", Sex.MALE, 12, "DSDFSDFDSFSFDD");
		Student sB = new Student("Bcbcasds", "LDfsdfsdf", Sex.MALE, 23, "EWRDSFDSFDSF");
		Student sC = new Student("Lbcasds", "ZDfsdfsdf", Sex.MALE, 2, "MDSFJSDJFSDF");
		Student sD = new Student("Abcasds", "JDfsdfsdf", Sex.MALE, 53, "CBNDKSDD");
		Student sE = new Student("Bbcasds", "ADfsdfsdf", Sex.MALE, 13, "98789897787667");
		
		
		Group g = new Group();
		
		try {
			g.pushStudent(sA);
			g.pushStudent(sB);
			g.pushStudent(sC);
			g.pushStudent(sD);
			g.pushStudent(sE);
			
			g.createStudent();
			
			g.createStudent();
			
		} catch(IllegalStudentException | GroupDuplicateException e) {
			System.out.println(e.getMessage());
		}
		
		g.sortByAgeDesc();
		System.out.println(g.toString());
		
		Student[] draftees = g.getDraftees();
		
		for (int i = 0; i < draftees.length; ++i) {
			System.out.println(draftees[i].toString());
		}
	}
}
