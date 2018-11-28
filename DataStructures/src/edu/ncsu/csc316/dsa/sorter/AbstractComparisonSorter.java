/**
 * 
 */
package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * ComparisonSorter abstraction...
 * Template taken from lab 1 manual
 * @author nicholasrrichardson
 * @author Dr.King
 * @param <E> generic class.
 */
public abstract class AbstractComparisonSorter<E extends Comparable<E>> implements Sorter<E> {

	private Comparator<E> comparator;
	/**
	 * Constructor...
	 * @param comparator specifies comparator to be used.
	 */
	public AbstractComparisonSorter(Comparator<E> comparator) {
		setComparator(comparator);
	}
	
	
	/**
	 * Sets comparator.
	 * @param comparator sets comparator.
	 */
	private void setComparator(Comparator<E> comparator) {
		if(comparator == null) {
			comparator = new NaturalOrder();
		}
		this.comparator = comparator;
	}
	/**
	 * Inner class for natural order comparator.
	 * @author nicholasrrichardson
	 * @author Dr.King
	 */
	private class NaturalOrder implements Comparator<E> {
		public int compare(E first, E second) {
			return ((Comparable<E>) first).compareTo(second);
		}
	}
	/**
	 * Compare method.
	 * Calls compare method based on specified comparator.
	 * @param data1 data set 1
	 * @param data2 data set 2
	 * @return int comparison.
	 */
	public int compare(E data1, E data2) {
		return comparator.compare(data1, data2);
	}
	
}
