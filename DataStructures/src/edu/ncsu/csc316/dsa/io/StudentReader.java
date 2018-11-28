/**
 * 
 */
package edu.ncsu.csc316.dsa.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import edu.ncsu.csc316.dsa.data.Student;

/**
 * Processes text files with Student information.
 * @author Dr.King
 * @author nicholasrrichardson
 *
 */
public class StudentReader {
	
	/**
	 * Returns an array of Student objects processed
	 * from the given input file.
	 * 
	 * Taken from lab manual....
	 * @param filepath the path of the file.
	 * @return an array of Students
	 */
	public static Student[] readInput(String filepath)
	{
		Student[] list = new Student[10];
		try(Scanner scan = new Scanner(new FileInputStream(filepath), "UTF8"))
		{
			scan.nextLine();
			int index = 0;
			while(scan.hasNextLine())
			{
				if(index >= list.length)
				{
					list = Arrays.copyOf(list, list.length * 2 + 1);
				}
				list[index] = processLine(scan.nextLine());
				index++;
			}
			list = Arrays.copyOf(list,  index);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File not found: " + e.getMessage());
		}
		return list;
	}
	
	private static Student processLine(String line) {
		try (Scanner scan = new Scanner(line)) {
			String[] dissection = line.split(",");
			Student result = new Student(dissection[0], dissection[1], Integer.parseInt(dissection[3]));
			return result;
		}
	}
}
