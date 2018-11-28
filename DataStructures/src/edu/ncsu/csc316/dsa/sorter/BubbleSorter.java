/**
 * 
 */
package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/** BubbleSort class.
 * @author nicholasrrichardson
 * @param <E> generic class.
 */
public class BubbleSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {
	/**
	 * Constructor.
	 * @param comparator - comparator provided.
	 */
	public BubbleSorter(Comparator<E> comparator)
	{
		super(comparator);
	}
	/**
	 * Default constructor.
	 */
	public BubbleSorter() {
		super(null);
	}
	
	/**
	 * Sorts with BubbleSort algorithm.
	 * Taken from lab 1 manual...
	 * @param data - array to be sorted.
	 */
	public void sort(E[] data)
	{
		boolean flag = true;
		E hold;
		while(flag) {
			flag = false;
			for(int i = 1; i < data.length; i++) {
				if (compare(data[i], data[i - 1]) < 0) {
					hold = data[i - 1];
					data[i - 1] = data[i];
					data[i] = hold;
					flag = true;
				}
			}
		}
	}
}
