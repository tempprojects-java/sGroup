package com.gmail.gak.artem;

public class Group {

	private Student[] students;

	public Group() {
		super();
		this.students = new Student[10];
	}

	public boolean pushStudent(Student student) throws NullPointerException, GroupDuplicateException {
		if (student == null) {
			throw new NullPointerException();
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

	public boolean setStudent(Student student, int index) throws NullPointerException, GroupDuplicateException, GroupLimitException {
		if (student == null) {
			throw new NullPointerException();
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

	public boolean removeStudent(Student student) {
		int index = getStudentIndex(student);
		if (index == -1) {
			return false;
		}

		students[index] = null;
		return true;
	}

	public boolean isSetStudent(Student student) {
		int index = getStudentIndex(student);

		if (index == -1) {
			return false;
		}

		return true;
	}

	public int getStudentIndex(Student student) {
		for (int i = 0; i < students.length; ++i) {
			if (students[i] != null && students[i].equals(student)) {
				return i;
			}
		}

		return -1;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		if (students == null) {
			throw new NullPointerException();
		}

		// StudentLimitException

		this.students = students;
	}
	
	@Override
	public String toString() {
		Student[] buffer = students;
		
		Utility.sort(buffer, 0, students.length - 1);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < students.length; ++i) {
			if (students[i] == null) {
				sb.append("null\n");
				continue;
			}
			sb.append(students[i].getFullName() + "\n");
		}

		return sb.toString();
	}

}
