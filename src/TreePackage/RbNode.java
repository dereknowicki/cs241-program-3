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

public class RbNode<T> extends BinaryNode<T> {
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
	
	public NodeColor getNodeColor() {
		return color;
	}
	
	public RbNode<T> getLeftChild(){
		return leftChild;
	}
	
	public RbNode<T> getRightChild(){
		return rightChild;
	}
}
