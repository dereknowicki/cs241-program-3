/****************************************************************
 * file: SearchTreeInterface.java 
 * author: Derek Nowicki
 * class: CS 241 – Data Structures and Algorithms II
 * 
 * assignment: program 3
 * date last modified: 2018-02-26
 * 
 * purpose: This interface extends the Tree Interface to
 * define a Search Tree data structure.
 * 
 ****************************************************************/

package TreePackage;

public interface SearchTreeInterface<T extends Comparable<? super T>> extends TreeInterface<T>{
	public boolean contains(T entry);
	public T getEntry(T entry);
	public T add(T newEntry);
	public T remove(T entry);
	
}
