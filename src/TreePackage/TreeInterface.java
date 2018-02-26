/****************************************************************
 * file: TreeInterface.java 
 * author: Derek Nowicki
 * class: CS 241 – Data Structures and Algorithms II
 * 
 * assignment: program 3
 * date last modified: 2018-02-26
 * 
 * purpose: This interface defines the methods for a Tree
 * data structure
 * 
 ****************************************************************/

package TreePackage;

public interface TreeInterface<T> {
	public T getRootData();
	public int getHeight();
	public int getNumberOfNodes();
	public boolean isEmpty();
	public void clear();
}
