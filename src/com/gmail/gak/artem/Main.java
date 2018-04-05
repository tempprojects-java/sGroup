package com.gmail.gak.artem;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		Group group = new Group();
		
		testGroupPushStudent(group, generaeteRandomStudent("DfisSurname", "Sname #3", Sex.MALE));
		testGroupPushStudent(group, generaeteRandomStudent("DasdfSurname", "Sname #2", Sex.MALE));
		testGroupPushStudent(group, generaeteRandomStudent("ZGndsSurname", "Sname #1", Sex.MALE));
		testGroupPushStudent(group, generaeteRandomStudent("AsdwSurname", "Sname #4", Sex.MALE));
		
		testGroupPushStudentByIndex(group, 11, generaeteRandomStudent("CsdsAsdwSurname", "Sname #4", Sex.MALE));
		testGroupPushStudentByIndex(group, 9, generaeteRandomStudent("HdjdAsdwSurname", "Sname #4", Sex.MALE));
		
		System.out.println("\n\n------- Students -----------\n\n");
		System.out.println(group.toString());
	}
	
	public static Student generaeteRandomStudent(String name, String surname, Sex sex) {
		Student student = new Student(name, surname, sex);
		
		double random = new Random().nextDouble();
		student.setGpa(1 + (random * 11));
		student.setTruancies((int)(Math.random() * 10));
		
		return student;
	}

	public static void testGroupPushStudent(Group group, Student student) {
		try {
			group.pushStudent(student);
		} catch(GroupDuplicateException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void testGroupPushStudentByIndex(Group group, int index, Student student) {
		try {
			if(!group.setStudent(student, index)) {
				System.out.println("Sorry, but this place is taken.");
			}
		} catch(GroupLimitException | GroupDuplicateException  e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void testGroupRemoveStudent(Group group, Student student) {
		if(!group.removeStudent(student)) {
			System.out.println("Student not found.");
		}
	}
}
