/****************************************************************
 * file: RbNode.java 
 * author: Derek Nowicki
 * class: CS 241 – Data Structures and Algorithms II
 * 
 * assignment: program 3
 * date last modified: 2018-02-26
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
	static Logger log = new Logger();
	
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
		leftChild = newRightChild;
	}
	
	public RbNode<T> getLeftChild(){
		return leftChild;
	}
	
	public RbNode<T> getRightChild(){
		return rightChild;
	}
}
