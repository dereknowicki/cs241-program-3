/****************************************************************
 * file: RbNode.java 
 * author: Derek Nowicki
 * class: CS 241 – Data Structures and Algorithms II
 * 
 * assignment: program 3
 * date last modified: 2018-02-28
 * 
 * purpose: This class extends the BinaryNode class to create a
 * node for Red Black Tree data structures
 * 
 ****************************************************************/

package TreePackage;

enum NodeColor{ RED, BLACK }

public class RbNode<T> {
	protected T data;
	private NodeColor color = NodeColor.BLACK;
	private RbNode<T> leftChild;
	private RbNode<T> rightChild;
	
	public RbNode() {
		this (null);
	}
	
	public RbNode(T dataPortion) {
		this (dataPortion, null, null);
	}
	
	public RbNode(T dataPortion, RbNode<T> newLeftChild, RbNode<T> newRightChild) {
		data = dataPortion;
		leftChild = newLeftChild;
		rightChild = newRightChild;
	}
	
	public RbNode<T> copy(){
		RbNode<T> newRoot = new RbNode<>(data);
		if(leftChild != null) {
			newRoot.setLeftChild(leftChild.copy());
		}
		if(rightChild != null) {
			newRoot.setRightChild(rightChild.copy());
		}
		return newRoot;
	}
	
	public boolean hasLeftChild() {
		return leftChild != null;
	}
	
	public boolean hasRightChild() {
		return rightChild != null;
	}
	
	public NodeColor getNodeColor() {
		return color;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T newData) {
		data = newData;
	}
	
	public void setLeftChild(RbNode<T> newLeftChild) {
		leftChild = newLeftChild;
	}
	
	public void setRightChild(RbNode<T> newRightChild) {
		rightChild = newRightChild;
	}
	
	public RbNode<T> getLeftChild(){
		return leftChild;
	}
	
	public RbNode<T> getRightChild(){
		return rightChild;
	}
	
	public int getHeight() {
		return getHeight(this);
	}
	
	private int getHeight(RbNode<T> node) {
		int height = 0;
		if(node != null) {
			height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
		}
		return height;
	}
	
	public int getNumberOfLeaves() {
		return getNumberOfLeaves(this);
	}
	
	private int getNumberOfLeaves(RbNode<T> node) {
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
}
