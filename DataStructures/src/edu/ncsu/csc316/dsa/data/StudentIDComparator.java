/**
 * 
 */
package edu.ncsu.csc316.dsa.data;

import java.util.Comparator;

/** Comparator for Students.
 * @author nicholasrrichardson
 *
 */
public class StudentIDComparator implements Comparator<Student> {
	/**
	 * Compare method.
	 * @param student1 first object.
	 * @param student2 second object.
	 * @return comparison
	 */
	@Override
	public int compare(Student student1, Student student2)
	{
		int id1 = student1.getId();
		int id2 = student2.getId();
		int result = 0;
		if (id1 > id2)
		{
			result =  1;
		}
		if (id1 < id2)
		{
			result = -1;
		}
		return result;
	}
}
