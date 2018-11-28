package edu.ncsu.csc316.dsa.sorter;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Merge sorter.
 * @author nicholasrrichardson
 * @param <E> - Generic comparison class.
 */
public class MergeSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * Merge sorter.
	 * @param comparator - Specified comparator.
	 */
	public MergeSorter(Comparator<E> comparator) {
		super(comparator);
	}
	/**
	 * Default constructor.
	 */
	public MergeSorter() {
		super(null);
	}

	@Override
	public void sort(E[] data) {
		int n = data.length;
		
		if (n >= 2)
		{
			int mid = n / 2;
			E[] left = Arrays.copyOfRange(data, 0 , mid);
			E[] right = Arrays.copyOfRange(data, mid , n);
			
			sort(left);
			sort(right);
			
			merge(left, right, data);
		}
		
	}

	
	
	private void merge(E[] left, E[] right, E[] t)
	{
		int n = t.length;
		int leftIndex = 0;
		int rightIndex = 0;
		while (leftIndex + rightIndex < n)
		{
			if ((rightIndex == right.length) || ( (leftIndex < left.length) && (compare(left[leftIndex], right[rightIndex]) < 0)))
					{
						t[leftIndex + rightIndex] = left[leftIndex];
						leftIndex++;
					}
			else
			{
		        t[leftIndex + rightIndex] = right[rightIndex];
				rightIndex++;
			}
		}
	}

}
