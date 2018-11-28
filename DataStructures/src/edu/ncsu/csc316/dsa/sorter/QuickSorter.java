package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;
import java.util.Random;

/**
 * QuickSorter.
 * @author nicholasrrichardson
 *
 * @param <E> - Generic element class.
 */
public class QuickSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E>
{
    private PivotSelector selector;
	/**
	 * FirstElement pivot
	 */
    public static final PivotSelector FIRST_ELEMENT_SELECTOR = new FirstElementSelector();
    /**
     * LastElement pivot
     */
    public static final PivotSelector LAST_ELEMENT_SELECTOR = new LastElementSelector();
    /**
     * MiddleElement pivot
     */
    public static final PivotSelector MIDDLE_ELEMENT_SELECTOR = new MiddleElementSelector();
    /**
     * RandomElement pivot
     */
    public static final PivotSelector RANDOM_ELEMENT_SELECTOR = new RandomElementSelector();

	/**
	 * Constructor
	 * @param comparator - Comparator to be used
	 * @param selector - pivotSelector to be used
	 */
	public QuickSorter(Comparator<E> comparator, PivotSelector selector) {
		super(comparator);
		setSelector(selector);
	}
	/**
	 * PivotSelector constructor
	 * @param selector - PivotSelector to be used
	 */
	public QuickSorter(PivotSelector selector)
	{
		this(null, selector);
	}
	/**
	 * Comparator constructor
	 * @param comparator - Comparator to be used
	 */
	public QuickSorter(Comparator<E> comparator)
	{
		this(comparator, null);
	}
	/**
	 * No-arg constructor
	 */
	public QuickSorter()
	{
		this(null, null);
	}
	@Override
	public void sort(E[] data) {		
		quickSort(data, 0, data.length - 1);
	}
	
	/**
	 * Interface for pivots
	 * @author nicholasrrichardson
	 *
	 */
	private interface PivotSelector 
	{
		/**
		 * Returns the index of the selected pivot element
		 * @param low - The lowest index to consider
		 * @param high - The highest index to consider
		 * @return the index of the selected pivot element
		 */
		int selectPivot(int low, int high);
	}
	/**
	 * Provides the lowest pivot
	 * @author nicholasrrichardson
	 *
	 */
	private static class FirstElementSelector implements PivotSelector
	{
		public int selectPivot(int low, int high)
		{
			return low;
		}
	}
	/**
	 * Provides the highest pivot
	 * @author nicholasrrichardson
	 *
	 */
	private static class LastElementSelector implements PivotSelector
	{
		public int selectPivot(int low, int high)
		{
			return high;
		}
	}
	/**
	 * Provides the middle pivot
	 * @author nicholasrrichardson
	 *
	 */
	private static class MiddleElementSelector implements PivotSelector
	{
		public int selectPivot(int low, int high)
		{
			return (high + low) / 2;
		}
	}
	/**
	 * Provides a random pivot.=
	 * @author nicholasrrichardson
	 *
	 */
	private static class RandomElementSelector implements PivotSelector
	{
		private Random r = new Random();
		public int selectPivot(int low, int high)
		{
			int rand = r.nextInt((high - low) + 1) + low;
			System.out.println(rand);
			return rand;
		}
	}

	private void setSelector(PivotSelector selector)
	{
		if (selector == null)
		{
			selector = new RandomElementSelector();
		}
		this.selector = selector;
	}

	private void quickSort(E[] data, int low, int high)
	{
		int pivotLocation; 
		if (low < high)
		{
			pivotLocation = partition(data, low, high);
			quickSort(data, low, pivotLocation - 1);
			quickSort(data, pivotLocation + 1, high);
		}
	}

	private int partition(E[] data, int low, int high)
	{
		int pivotIndex = selector.selectPivot(low, high);
		swap(data, pivotIndex, high);
		return partitionHelper(data, low, high);
	}
	
	private int partitionHelper(E[] data, int low, int high)
	{
		E pivot = data[high];
		int index = low;
		for (int j = low; j < high; j++)
		{
			if (compare(data[j], pivot) <= 0)
			{
				swap(data, index, j);
				index++;
			}
		}
		swap(data, index, high);
		return index;
	}
	
	private void swap(E[] data, int low, int high)
	{
		E hold = data[high];
		data[high] = data[low];
		data[low] = hold;
	}
}
