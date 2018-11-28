package edu.ncsu.csc316.dsa.set;
/**
 * Set interface
 * @author nicholasrrichardson
 *
 * @param <E> - Generic element class
 */
public interface Set<E> extends Iterable<E> {
	/**
	 * Adds the value to the set
	 * @param value - the value to be added
	 */
    void add(E value);
    /**
     * Returns true if the value given is in the set
     * @param value - the given value
     * @return a boolean
     */
    boolean contains(E value);
    /**
     * Removes the value from the set
     * @param value - the value to be removed
     * @return the value removed
     */
    E remove(E value);
    /**
     * Adds a set to the set
     * @param t the set to be added
     */
    void addAll(Set<E> t);
    /**
     * Retains all elements of the given set
     * @param t - set of elements to be retained
     */
    void retainAll(Set<E> t);
    /**
     * removes all elements of the set
     * @param t - the set to be removed
     */
    void removeAll(Set<E> t);
    /**
     * The size of the set
     * @return number of elements in the set
     */
    int size();
    /**
     * Tells if empty
     * @return boolean
     */
    boolean isEmpty();
}
