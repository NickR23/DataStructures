package edu.ncsu.csc316.dsa.map;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;
/**
 * UnorderedLinkedMap
 * @author nicholasrrichardson
 *
 * @param <K> - generic key class
 * @param <V> - generic value class
 */
public class UnorderedLinkedMap<K, V> extends AbstractMap<K, V> {

    private PositionalList<Entry<K, V>> list;
    /**
     * Constructor
     */
    public UnorderedLinkedMap() {
        this.list = new PositionalLinkedList<Entry<K, V>>();
    }
    
    private Position<Entry<K, V>> lookUp(K key)
    {
		Iterator<Position<Entry<K, V>>> itr = list.positions().iterator();
		while(itr.hasNext())
		{
			Position<Entry<K, V>> p = itr.next();
			if(p.getElement().getKey() == key)
			{
				return p;
			}
		}
    	return null;
    }

    @Override
    public V get(K key) {
        Position<Entry<K, V>> p = lookUp(key);
        V value = null;
        if(p == null)
        {
        		return null;
        }
    		value = p.getElement().getValue();
    		moveToFront(p);
        
		return value;
    }
    
    private void moveToFront(Position<Entry<K, V>> position) {
    		list.addFirst(position.getElement());
    		list.remove(position);
    }

    @Override
    public V put(K key, V value) {
        Position<Entry<K, V>> p = lookUp(key);
        if(p != null)
        {
        		p.getElement().setValue(value);
        		moveToFront(p);
        }
        else
        {
        		list.addFirst(new MapEntry<K, V>(key, value));
        }
		return value;
    }
    
    @Override
    public V remove(K key) {
       Position<Entry<K, V>> p = lookUp(key);
       V value = p.getElement().getValue();
       list.remove(p);
       return value;
    }
    
    @Override
    public int size() {
        return list.size();
    }
    
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        PositionalList<Entry<K, V>> set = new PositionalLinkedList<Entry<K, V>>();
        for(Entry<K, V> m : list) {
            set.addLast(m);
        }
        return set;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + "[");
        Iterator<Entry<K, V>> it = list.iterator();
        while(it.hasNext()) {
            sb.append(it.next().getKey());
            if(it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}