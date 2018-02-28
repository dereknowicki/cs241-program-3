/****************************************************************
 * file: BinaryTree.java 
 * author: Derek Nowicki
 * class: CS 241 – Data Structures and Algorithms II
 * 
 * assignment: program 3
 * date last modified: 2018-02-28
 * 
 * purpose: This class defines a Binary Tree data structure
 * 
 ****************************************************************/

package TreePackage;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable<? super T>> implements BinaryTreeInterface<T>{
	/************ INSTANCE VARIABLES ************/
	protected BinaryNode<T> root;
	
	/************ CONSTRUCTORS ************/
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(T rootData) {
		root = new BinaryNode<>(rootData);
	}
	
	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		privateSetTree(rootData, leftTree, rightTree);
	}
	
	/************ MEMBER METHODS ************/
	/**
	 * method: privateSetTree
	 * @param rootData
	 * @param leftTree
	 * @param rightTree
	 * purpose: create a tree from 2 other trees and a new root
	 */
	private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		root = new BinaryNode<>(rootData);
		if((leftTree != null) && !leftTree.isEmpty()) {
			root.setLeftChild(leftTree.root);
		}
			
		if((rightTree != null) && !rightTree.isEmpty()) {
			if(rightTree != leftTree)
				root.setRightChild(rightTree.root);
			else
				root.setRightChild(rightTree.root.copy());
		}
		
		if((leftTree != null) && (leftTree != this)) {
			leftTree.clear();
		}
		
		if((rightTree != null) && (rightTree != this)) {
			rightTree.clear();
		}
	}
	
	/**
	 * method: inorderTraverse
	 * @return
	 * purpose: accessor method
	 */
	public List<T> inorderTraverse() {
		return inorderTraverse(root);
	}
	
	/**
	 * method: preorderTraverse
	 * @return
	 * purpose: accessor method
	 */
	public List<T> preorderTraverse() {
		return preorderTraverse(root);
	}
	
	/**
	 * method: preorderTraverse
	 * @param node
	 * @return
	 * purpose: returns a list of the values of the tree
	 * from an preorder traversal
	 */
	private List<T> preorderTraverse(BinaryNode<T> node) {
		List<T> traversal = new ArrayList<T>();
		if(node != null) {
			traversal.add(node.getData());
			traversal.addAll(preorderTraverse(node.getLeftChild()));
			traversal.addAll(preorderTraverse(node.getRightChild()));
		}
		
		return traversal;
	}
	
	/**
	 * method: inorderTraverse
	 * @param node
	 * @return
	 * purpose: returns a list of the values of the tree
	 * from an inorder traversal
	 */
	private List<T> inorderTraverse(BinaryNode<T> node) {
		List<T> inorder = new ArrayList<T>();
		if(node != null) {
			inorder.addAll(inorderTraverse(node.getLeftChild()));
			inorder.add(node.getData());
			inorder.addAll(inorderTraverse(node.getRightChild()));
		}
		return inorder;
	}
	
	/**
	 * method: getNodesInRange
	 * @param low
	 * @param high
	 * @return
	 * purpose: accessor method
	 */
	public List<T> getNodesInRange(T low, T high) {
		return getNodesInRange(root, low, high);
	}
	
	/**
	 * method: getNodesInRange
	 * @param node
	 * @param low
	 * @param high
	 * @return
	 * purpose: returns a list of nodes in the specified range
	 */
	private List<T> getNodesInRange(BinaryNode<T> node, T low, T high) {
		List<T> range = new ArrayList<T>();
		if(node != null) {
			int lowComp = low.compareTo(node.getData()); //should be positive
			int hiComp = high.compareTo(node.getData()); //should be negative
			if(lowComp < hiComp) {
				range.add(node.getData());
			}
			range.addAll(getNodesInRange(node.getLeftChild(), low, high));
			range.addAll(getNodesInRange(node.getRightChild(), low, high));
		}
		
		return range;
	}
	
	/************ PROTECTED MEMBER METHODS ************/
	/**
	 * method: setRootData
	 * @param rootData
	 * purpose: set the data property of the root node
	 */
	protected void setRootData(T rootData) {
		root.setData(rootData);
	}
	
	/**
	 * method: setRootNode
	 * @param rootNode
	 * purpose: set the root node
	 */
	protected void setRootNode(BinaryNode<T> rootNode) {
		root = rootNode;
	}
	
	/**
	 * method: getRootNode
	 * @return
	 * purpose: accessor method
	 */
	protected BinaryNode<T> getRootNode() {
		return root;
	}

	/************ INTERFACE OVERRIDES ************/
	/* (non-Javadoc)
	 * @see TreePackage.TreeInterface#getRootData()
	 */
	@Override
	public T getRootData() {
		T rootData = null;
		if(root != null) {
			return rootData;
		}
		return rootData;
	}

	/* (non-Javadoc)
	 * @see TreePackage.TreeInterface#getHeight()
	 */
	@Override
	public int getHeight() {
		return root != null ? root.getHeight() : 0;
	}

	/* (non-Javadoc)
	 * @see TreePackage.TreeInterface#getNumberOfNodes()
	 */
	@Override
	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}

	/* (non-Javadoc)
	 * @see TreePackage.TreeInterface#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return root == null;
	}

	/* (non-Javadoc)
	 * @see TreePackage.TreeInterface#clear()
	 */
	@Override
	public void clear() {
		root = null;
	}

	/* (non-Javadoc)
	 * @see TreePackage.BinaryTreeInterface#setTree(java.lang.Object)
	 */
	@Override
	public void setTree(T rootData) {
		root = new BinaryNode<>(rootData);
	}

	/* (non-Javadoc)
	 * @see TreePackage.BinaryTreeInterface#setTree(java.lang.Object, TreePackage.BinaryTreeInterface, TreePackage.BinaryTreeInterface)
	 */
	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		privateSetTree(rootData, (BinaryTree<T>)leftTree, (BinaryTree<T>)rightTree);
	}

	/* (non-Javadoc)
	 * @see TreePackage.TreeInterface#getNumberOfLeaves()
	 */
	@Override
	public int getNumberOfLeaves() {
		return root.getNumberOfLeaves();
	}

}
