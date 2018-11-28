package edu.ncsu.csc316.dsa.sorter;
/**
 * Sorter Interface.
 * @author nicholasrrichardson
 *
 * @param <E> generic class.
 */
public interface Sorter <E> {
	/**
	 * Sort method.
	 * @param data provided data.
	 */
	public void sort(E[] data);
}
