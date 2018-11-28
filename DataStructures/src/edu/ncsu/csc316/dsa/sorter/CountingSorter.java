/**
 * 
 */
package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/** Template taken from lab 1 manual...
 * @author nicholasrrichardson
 * @author Dr.King
 * @param <E> generic class.
 */
public class CountingSorter<E extends Identifiable> implements Sorter<E> {
	/**
	 * Selection sort algorithm.
	 * Taken from lab 1 manual pseudocode...
	 * @param data - data to be sorted.
	 */
	@SuppressWarnings("unchecked")
	public void sort(E[] data) {
		int min = data[0].getId();
		int max = data[0].getId();
		//Find min and max value in data.
		for(int i = 0; i < data.length; i++) {
			if(min > data[i].getId()) {
				min = data[i].getId();
			}
			else if(max < data[i].getId()) {
				max = data[i].getId();
			}
		}
		
		//Calculate the range.
		int k = ((max - min) + 1);

		int[] b = new int[k];
		for (int i = 0; i < data.length; i++) {
			b[data[i].getId() - min] = b[data[i].getId() - min] + 1;
		}
		
		for(int i = 1; i < k; i++) {
			b[i] = b[i - 1] + b[i];
		}
		
		E[] hold = (E[])(new Identifiable[data.length]);
		for (int i = 0; i < data.length; i++) {
			hold[ b[data[i].getId() - min] - 1] = data[i];
			b[data[i].getId() - min] = b[data[i].getId() - min] - 1;
		}
		for(int i = 0; i < data.length; i++) {
			data[i] = (E)hold[i];
		}
	}
}
