/****************************************************************
 * file: RedBlackTree.java 
 * author: Derek Nowicki
 * class: CS 241 – Data Structures and Algorithms II
 * 
 * assignment: program 3
 * date last modified: 2018-02-26
 * 
 * purpose: This class impliments the Binary Tree interface to
 * define a Red Black Tree data structure.
 * 
 ****************************************************************/

package TreePackage;

import java.util.ArrayList;
import java.util.List;

public class RedBlackTree<T extends Comparable<? super T>> implements BinaryTreeInterface<T> {
	protected RbNode<T> root;
	
	public RedBlackTree() {
		root = null;
	}
	
	public RedBlackTree(T rootData) {
		root = new RbNode<>(rootData);
	}
	
	public RedBlackTree(T rootData, RedBlackTree<T> leftTree, RedBlackTree<T> rightTree) {
		privateSetTree(rootData, leftTree, rightTree);
	}
	
	public List<T> preorderTraverse() {
		return preorderTraverse(root);
	}
	
	private List<T> preorderTraverse(RbNode<T> node) {
		List<T> traversal = new ArrayList<T>();
		if(node != null) {
			traversal.add(node.getData());
			traversal.addAll(preorderTraverse(node.getLeftChild()));
			traversal.addAll(preorderTraverse(node.getRightChild()));
		}
		
		return traversal;
	}
	
	public List<T> inorderTraverse() {
		return inorderTraverse(root);
	}
	
	private List<T> inorderTraverse(RbNode<T> node) {
		List<T> inorder = new ArrayList<T>();
		if(node != null) {
			inorder.addAll(inorderTraverse(node.getLeftChild()));
			inorder.add(node.getData());
			inorder.addAll(inorderTraverse(node.getRightChild()));
		}
		return inorder;
	}
	
	public List<T> getNodesInRange(T low, T high) {
		return getNodesInRange(root, low, high);
	}
	
	private List<T> getNodesInRange(RbNode<T> node, T low, T high) {
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
	
	private void privateSetTree(T rootData, RedBlackTree<T> leftTree, RedBlackTree<T> rightTree) {
		root = new RbNode<>(rootData);
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
	
	public T add(T newEntry) {
		T result = null;
		if (isEmpty()) {
			root = new RbNode<T>(newEntry);
		} else {
			result = addEntry(root, newEntry);
		}
		return result;
	}
	
	private T addEntry(RbNode<T> rootNode, T newEntry) {
		assert rootNode != null;
		T result = null;
		int comparison = newEntry.compareTo(rootNode.getData());
		
		if(comparison == 0) {
			result = rootNode.getData();
			rootNode.setData(newEntry);
		}else if (comparison < 0) {
			if(rootNode.hasLeftChild()) {
				result = addEntry(rootNode.getLeftChild(), newEntry);
			} else {
				rootNode.setLeftChild(new RbNode<>(newEntry));
			}
		} else {
			assert comparison > 0;
			if(rootNode.hasRightChild()) {
				result = addEntry(rootNode.getRightChild(), newEntry);
			} else {
				rootNode.setRightChild(new RbNode<>(newEntry));
			}
		}
		return result;
	}
	
	protected RbNode<T> getRootNode() {
		return root;
	}
	
	protected void setRootNode(RbNode<T> rootNode) {
		root = rootNode;
	}
	
	private RbNode<T> findLargest(RbNode<T> rootNode){
		if(rootNode.hasRightChild()) {
			rootNode = findLargest(rootNode.getRightChild());
		}
		return rootNode;
	}
	
	public T remove(T entry) {
		ReturnObject oldEntry = new ReturnObject();
		RbNode<T> newRoot = removeEntry(getRootNode(), entry, oldEntry);
		setRootNode(newRoot);
		return oldEntry.get();
	}
	
	private RbNode<T> removeEntry(RbNode<T> rootNode, T entry, ReturnObject oldEntry){
		if(rootNode != null) {
			T rootData = rootNode.getData();
			int comparison = entry.compareTo(rootData);
			if(comparison == 0) {
				oldEntry.set(rootData);
				rootNode = removeFromRoot(rootNode);
			} else if(comparison < 0) {
				RbNode<T> leftChild = rootNode.getLeftChild();
				rootNode.setLeftChild(removeEntry(leftChild, entry, oldEntry));
			} else {
				RbNode<T> rightChild = rootNode.getRightChild();
				rootNode.setRightChild(removeEntry(rightChild, entry, oldEntry));
			}
		}
		return rootNode;
	}
	
	private RbNode<T> removeFromRoot(RbNode<T> rootNode){
		if(rootNode.hasLeftChild() && rootNode.hasRightChild()) {
			RbNode<T> leftSubtreeRoot = rootNode.getLeftChild();
			RbNode<T> largestNode = findLargest(leftSubtreeRoot);
			rootNode.setData(largestNode.getData());
			rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
		} else if(rootNode.hasRightChild()) {
			rootNode = rootNode.getRightChild();
		} else {
			rootNode = rootNode.getLeftChild();
		}
		return rootNode;
	}
	
	private RbNode<T> removeLargest(RbNode<T> rootNode){
		if(rootNode.hasRightChild()) {
			RbNode<T> rightChild = rootNode.getRightChild();
			rightChild = removeLargest(rightChild);
			rootNode.setRightChild(rightChild);
		} else {
			rootNode = rootNode.getLeftChild();
		}
		return rootNode;
	}

	@Override
	public T getRootData() {
		return root.getData();
	}

	@Override
	public int getHeight() {
		return root != null ? root.getHeight() : 0;
	}

	@Override
	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTree(T rootData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNumberOfLeaves() {
		return root.getNumberOfLeaves();
	}
	
	class ReturnObject {
		T data;
		
		public ReturnObject(){
			data = null;
		}
		
		public void set(T newData) {
			data = newData;
		}
		
		public T get() {
			return data;
		}
	}
}
