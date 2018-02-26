/****************************************************************
 * file: BinaryTreeInterface.java 
 * author: Derek Nowicki
 * class: CS 241 – Data Structures and Algorithms II
 * 
 * assignment: program 3
 * date last modified: 2018-02-26
 * 
 * purpose: This interface extends the Tree Interface to define
 * the methods for a Binary Tree data structure class
 * 
 ****************************************************************/

package TreePackage;

public interface BinaryTreeInterface<T> extends TreeInterface<T>{
	public void setTree(T rootData);
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree);
}
