
package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/**RadixSorter.
 * @author nicholasrrichardson
 * @author Dr.King
 * @param <E> - generic class.
 */
public class RadixSorter<E extends Identifiable> implements Sorter<E> {

	/**
	 * Pseudocode take from lab 1 manual.
	 * @param data - array to be sorted.
	 */
	@SuppressWarnings("unchecked")
	public void sort(E[] data) {
		int largestValue = 0;
		//find largest value.
		for (int i = 0; i < data.length; i++) {
			if (largestValue < data[i].getId()) {
				largestValue = data[i].getId();
			}
		}
		//Find # of digits in largest value.
		int x = 0;
		while(largestValue != 0) {
			largestValue /= 10;
			x++;
		}
		
		int p = 1;
		for(int j = 1; j <= x; j++) {
			int[] pigeonHole = new int[10];
			for(int i = 0; i < data.length; i++) {
				pigeonHole[ (data[i].getId() / p) % 10] = pigeonHole[ (data[i].getId() / p) % 10] + 1;
			}
			for(int i = 1; i <= 9; i++) {
				pigeonHole[i] = pigeonHole[i - 1] + pigeonHole[i];
			}
			
			
			Object[] hold = new Object[data.length];
			for(int i = data.length - 1; i >= 0; i--) {
				hold[ pigeonHole[ (data[i].getId() / p) % 10] - 1] = data[i];
				pigeonHole[ (data[i].getId() / p) % 10] = pigeonHole[ (data[i].getId() / p) % 10] - 1;
			}
			
			for(int i = 0; i < data.length; i++) {
				//How to handle????
				data[i] = (E)hold[i];
			}
			p *= 10;
		}
	}
}
