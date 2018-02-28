/****************************************************************
 * file: BinaryTreeInterface.java 
 * author: Derek Nowicki
 * class: CS 241 – Data Structures and Algorithms II
 * 
 * assignment: program 3
 * date last modified: 2018-02-28
 * 
 * purpose: This interface extends the Tree Interface to define
 * the methods for a Binary Tree data structure class
 * 
 ****************************************************************/

package TreePackage;

public interface BinaryTreeInterface<T> extends TreeInterface<T>{
	/**
	 * method: setTree
	 * @param rootData
	 * purpose: set a tree with the given root data
	 */
	public void setTree(T rootData);
	
	/**
	 * method: setTree
	 * @param rootData
	 * @param leftTree
	 * @param rightTree
	 * purpose: create a new tree with a new root with the given data
	 * and the given left and right children trees
	 */
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree);
}
