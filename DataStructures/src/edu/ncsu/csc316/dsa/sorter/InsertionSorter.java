package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * Sorts by insertionSort algorithm.
 * @author nicholasrrichardson
 * @param <E> generic class.
 */
public class InsertionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {
	
	/**
	 * Constructor. Specifies which comparator to use...
	 * @param comparator used to make specified comparator.
	 */
	public InsertionSorter(Comparator<E> comparator)
	{
		super(comparator);
	}
	
	/**
	 * Default constructor...
	 */
	public InsertionSorter() {
		super(null);
	}
	
	/**
	 * Sorting algorithm.
	 * 	Implemented based on the pseudocode 
	 *  for insertion sort provided by 
	 *  lab 1 instructions.
	 * @param data to be sorted.
	 */

	public void sort(E[] data){
		for(int i = 1; i < data.length; i++)
		{
			E x = data[i];
			int j = i - 1;
			while (j >= 0 && (compare(data[j], x) > 0))
			{
				data[j + 1] = data[j];
				j--;
			}
			
			data[j + 1] = x;
		}
	}
	

}
