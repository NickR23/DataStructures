package edu.ncsu.csc316.dsa.set;
/**
 * Set Abstraction
 * @author nicholasrrichardson
 *
 * @param <E> - generic element class
 */
public abstract class AbstractSet<E> implements Set<E> {

    @Override
    public void addAll(Set<E> t) {
        for(E element : t) {
            add(element);
        }
    }

    @Override
    public void retainAll(Set<E> t) {
        for(E element : this) {
            if(!t.contains(element)) {
                remove(element);
            }
        }
    }

    @Override
    public void removeAll(Set<E> t) {
        for(E element : t) {
            remove(element);
        }
    }   
    
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}