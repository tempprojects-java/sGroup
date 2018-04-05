package com.gmail.gak.artem;

public class Utility {

	public Utility() {
		super();
	}
	
	public static void sort(Student[] students, int left, int right)
	{
	    if (left < right)
	    {
	        int pivotIndex = left - (left - right) / 2;
	        int newPivot = partition(students, left, right, pivotIndex);
	 
	        sort(students, left, newPivot - 1);
	        sort(students, newPivot + 1, right);
	    }
	}

	private static int partition(Student[] students, int left, int right, int pivotIndex)
	{
	    Student pivotValue = students[pivotIndex];
	 
	    swap(students, pivotIndex, right);
	 
	    int storeIndex = left;
	 
	    for (int i = left; i < right; ++i)
	    {
	        if (students[i] != null && students[i].compareTo(pivotValue) < 0)
	        {
	        	swap(students, i, storeIndex);
	            storeIndex += 1;
	        }
	    }
	 
	    swap(students, storeIndex, right);
	    return storeIndex;
	}
	
	private static void swap(Student[] students, int indexA , int indexB) {
		Student buffer = students[indexA];
		students[indexA] = students[indexB];
		students[indexB] = buffer;
	}

}
