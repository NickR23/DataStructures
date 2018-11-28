/**
 * 
 */
package edu.ncsu.csc316.dsa.data;

import java.util.Comparator;

/** Compares based on GPA.
 * @author nicholasrrichardson
 *
 */
public class StudentGPAComparator implements Comparator<Student> {
	/**
	 * Compare method.
	 * @param student1 object 1.
	 * @param student2 object 2.
	 */
	@Override
	public int compare(Student student1, Student student2)
	{
		double gpa1 = student1.getGpa();
		double gpa2 = student2.getGpa();
		int result = 0;
		if (gpa1 > gpa2)
		{
			result = 1;
		}
		if (gpa1 < gpa2)
		{
			result = -1;
		}
		return result;
	}
}
