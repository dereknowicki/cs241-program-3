/****************************************************************
 * file: BinaryTree.java 
 * author: Derek Nowicki
 * class: CS 241 – Data Structures and Algorithms II
 * 
 * assignment: program 3
 * date last modified: 2018-02-26
 * 
 * purpose: This class defines a Binary Tree data structure
 * 
 ****************************************************************/

package TreePackage;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> implements BinaryTreeInterface<T>{
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
	
	public List<T> inorderTraverse() {
		return inorderTraverse(root);
	}
	
	public List<T> preorderTraverse() {
		return preorderTraverse(root);
	}
	
	private List<T> preorderTraverse(BinaryNode<T> node) {
		List<T> traversal = new ArrayList<T>();
		if(node != null) {
			traversal.add(node.getData());
			traversal.addAll(preorderTraverse(node.getLeftChild()));
			traversal.addAll(preorderTraverse(node.getRightChild()));
		}
		
		return traversal;
	}
	
	private List<T> inorderTraverse(BinaryNode<T> node) {
		List<T> inorder = new ArrayList<T>();
		if(node != null) {
			inorder.addAll(inorderTraverse(node.getLeftChild()));
			inorder.add(node.getData());
			inorder.addAll(inorderTraverse(node.getRightChild()));
		}
		return inorder;
	}
	
	/************ PROTECTED MEMBER METHODS ************/
	protected void setRootData(T rootData) {
		root.setData(rootData);
	}
	
	protected void setRootNode(BinaryNode<T> rootNode) {
		root = rootNode;
	}
	
	protected BinaryNode<T> getRootNode() {
		return root;
	}

	/************ INTERFACE OVERRIDES ************/
	@Override
	public T getRootData() {
		T rootData = null;
		if(root != null) {
			return rootData;
		}
		return rootData;
	}

	@Override
	public int getHeight() {
		return root != null ? root.getHeight() : 0;
	}

	@Override
	public int getNumberOfNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void clear() {
		root = null;
	}

	@Override
	public void setTree(T rootData) {
		root = new BinaryNode<>(rootData);
	}

	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		privateSetTree(rootData, (BinaryTree<T>)leftTree, (BinaryTree<T>)rightTree);
	}

}
