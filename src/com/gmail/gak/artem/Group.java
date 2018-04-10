package com.gmail.gak.artem;

import java.util.Arrays;
import java.util.Scanner;

public class Group implements Commissariat {

	private Student[] students;

	public Group() {
		super();
		this.students = new Student[10];
	}

	public boolean createStudent() throws GroupDuplicateException, IllegalStudentException {
		return pushStudent(consoleCreateStudent());
	}

	protected Student consoleCreateStudent() {
		Scanner sc = new Scanner(System.in);
		return new Student(sc);
	}

	public boolean pushStudent(Student student) throws GroupDuplicateException, IllegalStudentException {
		if (student == null) {
			throw new IllegalArgumentException();
		}

		if (isSetStudent(student)) {
			throw new GroupDuplicateException();
		}

		for (int i = 0; i < students.length; ++i) {
			if (students[i] == null) {
				students[i] = student;
				return true;
			}
		}

		return false;
	}

	public boolean setStudent(Student student, int index) throws IllegalStudentException,GroupDuplicateException, GroupLimitException {
		if (student == null) {
			throw new IllegalArgumentException();
		}

		try {
			if (students[index] != null) {
				return false;
			} else if (isSetStudent(student)) {
				throw new GroupDuplicateException();
			}
			students[index] = student;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new GroupLimitException();
		}

		return true;
	}

	public boolean removeStudent(Student student) throws IllegalStudentException {
		int index = getStudentIndex(student);
		if (index == -1) {
			return false;
		}

		students[index] = null;
		return true;
	}

	public boolean isSetStudent(Student student) throws IllegalStudentException {
		int index = getStudentIndex(student);

		if (index == -1) {
			return false;
		}

		return true;
	}

	public int getStudentIndex(Student student) throws IllegalStudentException {
		if(student.getRcard() == null) {
			throw new IllegalStudentException();
		}
		
		for (int i = 0; i < students.length; ++i) {
			if (students[i] != null && students[i].getRcard().equals(student.getRcard())) {
				return i;
			}
		}

		return -1;
	}

	public Student findStudentBySurname(String surname) {
		if (surname == null) {
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < students.length; ++i) {
			if (students[i] != null && students[i].getSurname().equals(surname)) {
				return students[i];
			}
		}

		return null;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		if (students == null) {
			throw new IllegalArgumentException();
		}

		// StudentLimitException

		this.students = students;
	}

	public void sortByName() {
		Arrays.sort(students, (sA, sB) -> {
			if (sA == null) {
				return -1;
			}
			if (sB == null) {
				return 1;
			}
			if (sA.getName().compareTo(sB.getName()) < 0) {
				return -1;
			}
			if (sA.getName().compareTo(sB.getName()) > 0) {
				return 1;
			}

			return 0;
		});
	}

	public void sortBySurname() {
		Arrays.sort(students, (sA, sB) -> {
			if (sA == null) {
				return -1;
			}
			if (sB == null) {
				return 1;
			}
			if (sA.getSurname().compareTo(sB.getSurname()) < 0) {
				return -1;
			}
			if (sA.getSurname().compareTo(sB.getSurname()) > 0) {
				return 1;
			}

			return 0;
		});
	}

	public void sortByAge() {
		Arrays.sort(students, (sA, sB) -> {
			if (sA == null) {
				return -1;
			}
			if (sB == null) {
				return 1;
			}
			if (sA == null || sA.getAge() < sB.getAge()) {
				return -1;
			}
			if (sB == null || sA.getAge() > sB.getAge()) {
				return 1;
			}

			return 0;
		});
	}

	public void sortByAgeDesc() {
		Arrays.sort(students, (sA, sB) -> {
			if (sA == null) {
				return 1;
			}
			if (sB == null) {
				return -1;
			}
			if (sA.getAge() > sB.getAge()) {
				return -1;
			}
			if (sA.getAge() < sB.getAge()) {
				return 1;
			}

			return 0;
		});
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < students.length; ++i) {
			if (students[i] == null) {
				sb.append("null\n");
				continue;
			}
			sb.append(students[i].toString() + "\n");
		}

		return sb.toString();
	}

	@Override
	public Student[] getDraftees() {
		Student[] result = new Student[10];

		sortByAgeDesc();
		int counter = 0;
		for (int i = 0; i < students.length; ++i) {
			if (students[i] == null) {
				continue;
			}
			if (students[i].getAge() <= 18) {
				break;
			}
			if (students[i].getSex() == Sex.MALE) {
				result[counter] = students[i];
				counter += 1;
			}
		}

		return Arrays.copyOf(result, counter);
	}

}
