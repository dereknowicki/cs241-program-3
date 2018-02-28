/****************************************************************
 * file: BinaryNode.java 
 * author: Derek Nowicki
 * class: CS 241 – Data Structures and Algorithms II
 * 
 * assignment: program 3
 * date last modified: 2018-02-28
 * 
 * purpose: This class defines a node that can be used in a 
 * Binary Tree data structure
 * 
 ****************************************************************/

package TreePackage;

public class BinaryNode<T> {
	protected T data;
	private BinaryNode<T> leftChild;
	private BinaryNode<T> rightChild;
	
	public BinaryNode() {
		this (null);
	}
	
	public BinaryNode(T dataPortion) {
		this (dataPortion, null, null);
	}
	
	public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild, BinaryNode<T> newRightChild) {
		data = dataPortion;
		leftChild = newLeftChild;
		rightChild = newRightChild;
	}
	
	/**
	 * method: copy
	 * @return
	 * purpose: returns a copy of the object
	 */
	public BinaryNode<T> copy(){
		BinaryNode<T> newRoot = new BinaryNode<>(data);
		if(leftChild != null) {
			newRoot.setLeftChild(leftChild.copy());
		}
		if(rightChild != null) {
			newRoot.setRightChild(rightChild.copy());
		}
		return newRoot;
	}
	
	/**
	 * method: getData
	 * @return
	 * purpose: accessor method
	 */
	public T getData() {
		return data;
	}
	
	/**
	 * method: setData
	 * @param newData
	 * purpose: mutator method
	 */
	public void setData(T newData) {
		data = newData;
	}
	
	/**
	 * method: getLeftChild
	 * @return
	 * purpose: accessor method
	 */
	public BinaryNode<T> getLeftChild(){
		return leftChild;
	}
	
	/**
	 * method: setLeftChild
	 * @param newLeftChild
	 * purpose: mutator method
	 */
	public void setLeftChild(BinaryNode<T> newLeftChild) {
		leftChild = newLeftChild;
	}
	
	/**
	 * method: hasLeftChild
	 * @return
	 * purpose: returns true if this node has a left child
	 */
	public boolean hasLeftChild() {
		return leftChild != null;
	}
	
	/**
	 * method: getRightChild
	 * @return
	 * purpose: accessor method
	 */
	public BinaryNode<T> getRightChild(){
		return rightChild;
	}
	
	/**
	 * method: setRightChild
	 * @param newRightChild
	 * purpose: mutator method
	 */
	public void setRightChild(BinaryNode<T> newRightChild) {
		rightChild = newRightChild;
	}
	
	/**
	 * method: hasRightChild
	 * @return
	 * purpose: returns true if this node has a right child
	 */
	public boolean hasRightChild() {
		return rightChild != null;
	}
	
	/**
	 * method: isLeaf
	 * @return
	 * purpose: returns true if this node has no children
	 */
	public boolean isLeaf() {
		return (leftChild == null) && (rightChild == null);
	}
	
	/**
	 * method: getNumberOfNodes
	 * @return
	 * purpose: returns total number of nodes of this tree
	 */
	public int getNumberOfNodes() {
		int leftNum = 0;
		int rightNum = 0;
		if(leftChild != null) {
			leftNum = leftChild.getNumberOfNodes();
		}
		if(rightChild != null) {
			rightNum = rightChild.getNumberOfNodes();
		}
		return leftNum + rightNum + 1;
	}
	
	/**
	 * method: getHeight
	 * @return
	 * purpose: accessor method
	 */
	public int getHeight() {
		return getHeight(this);
	}
	
	/**
	 * method: getHeight
	 * @param node
	 * @return
	 * purpose: recursively calculates the height of the tree
	 */
	private int getHeight(BinaryNode<T> node) {
		int height = 0;
		if(node != null) {
			height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
		}
		return height;
	}
	
	/**
	 * method: getNumberOfLeaves
	 * @return
	 * purpose: accessor method
	 */
	public int getNumberOfLeaves() {
		return getNumberOfLeaves(this);
	}
	
	/**
	 * method: getNumberOfLeaves
	 * @param node
	 * @return
	 * purpose: returns the number of leaves in the tree
	 */
	private int getNumberOfLeaves(BinaryNode<T> node) {
		int leaves = 0;
		if(!(node.hasLeftChild() || node.hasRightChild())) {
			leaves = 1;
		}
		if(node.hasLeftChild()) {
			leaves += getNumberOfLeaves(node.getLeftChild());
		}
		if(node.hasRightChild()) {
			leaves += getNumberOfLeaves(node.getRightChild());
		}
		
		return leaves;
	}
}
