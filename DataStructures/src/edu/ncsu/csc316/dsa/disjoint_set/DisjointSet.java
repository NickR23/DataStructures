package edu.ncsu.csc316.dsa.disjoint_set;

import edu.ncsu.csc316.dsa.Position;

/**
 * Disjoint set interface
 * @author nicholasrrichardson
 * @param <E> - Generic element set
 */
public interface DisjointSet<E> {
	/**
	 * Makes a new set
	 * @param value - value to be stored
	 * @return the position
	 */
    Position<E> makeSet(E value);
    /**
     * Finds a value in the set
     * @param value - The value to be found
     * @return the position
     */
    Position<E> find(E value);
    /**
     * Unions two sets
     * @param s - the 1st position
     * @param t - the 2nd position
     */
    void union(Position<E> s, Position<E> t);
}
