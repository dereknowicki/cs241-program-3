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

	@Override
	public T getRootData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
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

}
