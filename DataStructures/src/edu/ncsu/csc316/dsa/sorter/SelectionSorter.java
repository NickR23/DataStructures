/**
 * 
 */
package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**Taken from lab 1 manual
 * @author nicholasrrichardson
 * @author Dr.King
 * @param <E> generic class.
 */
public class SelectionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {
	
	/**
	 * Constructor.
	 * @param comparator provided comparator.
	 */
	public SelectionSorter(Comparator<E> comparator) {
		super(comparator);
	}
	
	/**
	 * Default constructor.
	 */
	public SelectionSorter() {
		super(null);
	}
	
	/**
	 *  Sorts data by selectionSort.
	 *  Pseudocode take from lab 1 manual.
	 *  @param data provided array.
	 */
	public void sort(E[] data)
	{
		E hold = null;
		int min = 0;
		for (int i = 0; i < data.length; i++)
		{
			min = i;
			for (int j = i + 1; j < data.length; j++)
			{
				if (compare(data[j], data[min]) < 0) {
					min = j;
				}
			}
			hold = data[i];
			data[i] = data[min];
			data[min] = hold;
		}
	}

}
