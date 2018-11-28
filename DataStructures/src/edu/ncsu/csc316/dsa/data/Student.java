package edu.ncsu.csc316.dsa.data;
/**
 * Holds a data set for a student.
 * @author nicholasrrichardson
 *
 */
public class Student implements Comparable<Student>, Identifiable {
	private String first;
	private String last;
	private int id;
	private int creditHours;
	private double gpa;
	private String unityID;
	
	/**
	 * Constructor.
	 * @param first sets first.
	 * @param last sets last.
	 * @param id sets id.
	 */
	public Student(String first, String last, int id)
	{
		this.first = first;
		this.last = last;
		this.id = id;
	}
	/**
	 * Returns first.
	 * @return first.
	 */
	public String getFirst()
	{
		return first;
	}
	
	/**
	 * Sets first.
	 * @param first sets first.
	 */
	public void setFirst(String first)
	{
		this.first = first;
	}
	
	/**
	 * Returns last.
	 * @return last.
	 */
	public String getLast()
	{
		return last;
	}
	
	/**
	 * Sets last.
	 * @param last sets last.
	 */
	public void setLast(String last)
	{
		this.last = last;
	}
	
	/**
	 * Gets id.
	 * @return id.
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * Sets id.
	 * @param id sets id.
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	
	/**
	 * Gets creditHours.
	 * @return creditHours.
	 */
	public int getCreditHours()
	{
		return creditHours;
	}
	
	/**
	 * sets creditHours.
	 * @param creditHours sets creditHours.
	 */
	public void setCreditHours(int creditHours)
	{
		this.creditHours = creditHours;
	}
	
	/**
	 * Gets gpa.
	 * @return gpa.
	 */
	public double getGpa()
	{
		return gpa;
	}
	
	/**
	 * Sets gpa.
	 * @param gpa sets gpa.
	 */
	public void setGpa(double gpa)
	{
		this.gpa = gpa;
	}
	
	/**
	 * Gets unityId.
	 * @return unityID.
	 */
	public String getUnityId()
	{
		return unityID;
	}
	
	/**
	 * Sets unityID.
	 * @param unityID sets unityID.
	 */
	public void setUnityID(String unityID)
	{
		this.unityID = unityID;
	}
	
	/**
	 * Returns hash.
	 * @return hash.
	 */
	public int hashCode()
	{
		return id;
	}
	
	/**
	 * Test for equivalence.
	 * @param other is other object.
	 * @return boolean
	 */
	public boolean equals(Object other)
	{	
		//Student otherStudent = (Student)other;
		return this.hashCode() == other.hashCode();
	}
	
	/**
	 * Compares two student.
	 * @param other is other student.
	 * @return corresponding integer.
	 */
	public int compareTo(Student other)
	{
		int result = 0;
		if (this.id == other.id)
		{
			result = 0;
		}
		else if (this.last.compareTo(other.getLast()) < 0)
		{
			result =  -1;
		}
		else if (this.last.compareTo(other.getLast()) > 0)
		{
			result = 1;
		}
		else if (this.first.compareTo(other.getFirst()) < 0)
		{
			result =  -1;
		}
		else if (this.first.compareTo(other.getFirst()) > 0)
		{
			result = 1;
		}
		return result;
	}
	
	/**
	 * Returns string representation.
	 * @return string
	 */
	public String toString()
	{
		return last + ", " + first + ", " + id;
	}
}
