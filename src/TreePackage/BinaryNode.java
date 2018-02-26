/****************************************************************
 * file: BinaryNode.java 
 * author: Derek Nowicki
 * class: CS 241 – Data Structures and Algorithms II
 * 
 * assignment: program 3
 * date last modified: 2018-02-26
 * 
 * purpose: This class defines a node that can be used in a 
 * Binary Tree data structure
 * 
 ****************************************************************/

package TreePackage;

public class BinaryNode<T> {
	private T data;
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
	
	public T getData() {
		return data;
	}
	
	public void setData(T newData) {
		data = newData;
	}
	
	public BinaryNode<T> getLeftChild(){
		return leftChild;
	}
	
	public void setLeftChild(BinaryNode<T> newLeftChild) {
		leftChild = newLeftChild;
	}
	
	public boolean hasLeftChild() {
		return leftChild != null;
	}
	
	public BinaryNode<T> getRightChild(){
		return rightChild;
	}
	
	public void setRightChild(BinaryNode<T> newRightChild) {
		rightChild = newRightChild;
	}
	
	public boolean hasRightChild() {
		return rightChild != null;
	}
	
	public boolean isLeaf() {
		return (leftChild == null) && (rightChild == null);
	}
	
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
	
	public int getHeight() {
		return getHeight(this);
	}
	
	private int getHeight(BinaryNode<T> node) {
		int height = 0;
		if(node != null) {
			height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
		}
		return height;
	}
}































