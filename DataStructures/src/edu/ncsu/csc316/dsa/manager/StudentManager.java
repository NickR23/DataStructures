/**
 * 
 */
package edu.ncsu.csc316.dsa.manager;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.io.StudentReader;
import edu.ncsu.csc316.dsa.sorter.InsertionSorter;
import edu.ncsu.csc316.dsa.sorter.Sorter;

/**Manages a roster of students
 * @author Dr.King
 * @author nicholasrrichardson
 *
 */
public class StudentManager {
	
	/**
	 * A roster of Students.
	 */
	private Student[] roster;
	
	/**
	 * Sorter used to sort students.
	 */
	private Sorter<Student> sorter;
	
	/**
	 * Creates a new StudentManager given the path
	 * to an input file that contains Student information.
	 * @param pathToFile - provided path to file with Student information.
	 * @param sorter - the specified sorter.
	 */
	public StudentManager(String pathToFile, Sorter<Student> sorter)
	{
		roster = StudentReader.readInput(pathToFile);
		this.sorter = sorter;
	}
	
	/**
	 * Default constructor.
	 * @param pathToFile - the path to file containing Student information.
	 */
	public StudentManager(String pathToFile) {
		this(pathToFile, new InsertionSorter<Student>());
	}
	
	
	/**
	 * Returns a sorted array of Students
	 * @return a sorted array.
	 */
	public Student[] sort()
	{
		sorter.sort((Student[])roster);
		return roster;
	}
}
