/****************************************************************
 * file: BinarySearchTree.java 
 * author: Derek Nowicki
 * class: CS 241 – Data Structures and Algorithms II
 * 
 * assignment: program 3
 * date last modified: 2018-02-28
 * 
 * purpose: This class defines a Binary Search Tree data structure
 * 
 ****************************************************************/

package TreePackage;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> implements SearchTreeInterface<T> {
	/************ CONSTRUCTORS ************/
	public BinarySearchTree() {
		super();
	}
	
	public BinarySearchTree(T rootEntry) {
		super();
		setRootNode(new BinaryNode<T>(rootEntry));
	}
	
	
	/************ MEMBER METHODS ************/
	/**
	 * method: addEntry
	 * @param rootNode
	 * @param newEntry
	 * @return
	 * purpose: adds an entry to the search tree
	 */
	private T addEntry(BinaryNode<T> rootNode, T newEntry) {
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
				rootNode.setLeftChild(new BinaryNode<>(newEntry));
			}
		} else {
			assert comparison > 0;
			if(rootNode.hasRightChild()) {
				result = addEntry(rootNode.getRightChild(), newEntry);
			} else {
				rootNode.setRightChild(new BinaryNode<>(newEntry));
			}
		}
		return result;
	}
	
	/**
	 * method: removeEntry
	 * @param rootNode
	 * @param entry
	 * @param oldEntry
	 * @return
	 * purpose: removes an entry from the search tree
	 */
	private BinaryNode<T> removeEntry(BinaryNode<T> rootNode, T entry, ReturnObject oldEntry){
		if(rootNode != null) {
			T rootData = rootNode.getData();
			int comparison = entry.compareTo(rootData);
			if(comparison == 0) {
				oldEntry.set(rootData);
				rootNode = removeFromRoot(rootNode);
			} else if(comparison < 0) {
				BinaryNode<T> leftChild = rootNode.getLeftChild();
				rootNode.setLeftChild(removeEntry(leftChild, entry, oldEntry));
			} else {
				BinaryNode<T> rightChild = rootNode.getRightChild();
				rootNode.setRightChild(removeEntry(rightChild, entry, oldEntry));
			}
		}
		return rootNode;
	}
	
	/**
	 * method: removeFromRoot
	 * @param rootNode
	 * @return
	 * purpose: remove a node from the root
	 */
	private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode){
		if(rootNode.hasLeftChild() && rootNode.hasRightChild()) {
			BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild();
			BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);
			rootNode.setData(largestNode.getData());
			rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
		} else if(rootNode.hasRightChild()) {
			rootNode = rootNode.getRightChild();
		} else {
			rootNode = rootNode.getLeftChild();
		}
		return rootNode;
	}
	
	/**
	 * method: findLargest
	 * @param rootNode
	 * @return
	 * purpose: find the node with the largest value
	 */
	private BinaryNode<T> findLargest(BinaryNode<T> rootNode){
		if(rootNode.hasRightChild()) {
			rootNode = findLargest(rootNode.getRightChild());
		}
		return rootNode;
	}
	
	/**
	 * method: removeLargest
	 * @param rootNode
	 * @return
	 * purpose: remove the node with the largest value
	 */
	private BinaryNode<T> removeLargest(BinaryNode<T> rootNode){
		if(rootNode.hasRightChild()) {
			BinaryNode<T> rightChild = rootNode.getRightChild();
			rightChild = removeLargest(rightChild);
			rootNode.setRightChild(rightChild);
		} else {
			rootNode = rootNode.getLeftChild();
		}
		return rootNode;
	}
	
	/**
	 * method: findEntry
	 * @param rootNode
	 * @param entry
	 * @return
	 * purpose: find the node with the specified value
	 */
	private T findEntry(BinaryNode<T> rootNode, T entry) {
		T result = null;
		if(rootNode != null) {
			T rootEntry = rootNode.getData();
			if(entry.equals(rootEntry)) {
				result = rootEntry;
			} else if (entry.compareTo(rootEntry) < 0) {
				result = findEntry(rootNode.getLeftChild(), entry);
			} else {
				result = findEntry(rootNode.getRightChild(), entry);
			}
		}
		return result;
	}
	
	/************ INTERFACE OVERRIDES ************/
	/* (non-Javadoc)
	 * @see TreePackage.SearchTreeInterface#contains(java.lang.Comparable)
	 */
	@Override
	public boolean contains(T entry) {
		return getEntry(entry) != null;
	}

	/* (non-Javadoc)
	 * @see TreePackage.SearchTreeInterface#getEntry(java.lang.Comparable)
	 */
	@Override
	public T getEntry(T entry) {
		return findEntry(getRootNode(), entry);
	}

	/* (non-Javadoc)
	 * @see TreePackage.SearchTreeInterface#add(java.lang.Comparable)
	 */
	@Override
	public T add(T newEntry) {
		T result = null;
		if (isEmpty()) {
			root = new BinaryNode<T>(newEntry);
		} else {
			result = addEntry(root, newEntry);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see TreePackage.SearchTreeInterface#remove(java.lang.Comparable)
	 */
	@Override
	public T remove(T entry) {
		ReturnObject oldEntry = new ReturnObject();
		BinaryNode<T> newRoot = removeEntry(getRootNode(), entry, oldEntry);
		setRootNode(newRoot);
		return oldEntry.get();
	}
	
	/************ DISABLE BINARY TREE INTERFACE METHODS ************/
	/* (non-Javadoc)
	 * @see TreePackage.BinaryTree#setTree(java.lang.Comparable)
	 */
	public void setTree(T rootData) {
		throw new UnsupportedOperationException();
	}
	
	/* (non-Javadoc)
	 * @see TreePackage.BinaryTree#setTree(java.lang.Comparable, TreePackage.BinaryTreeInterface, TreePackage.BinaryTreeInterface)
	 */
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		throw new UnsupportedOperationException();
	}
	
	/************ INNER CLASSES ************/
	/**
	 * @author derek
	 * Generic return object class for use in this tree
	 */
	class ReturnObject {
		T data;
		
		public ReturnObject(){
			data = null;
		}
		
		/**
		 * method: set
		 * @param newData
		 * purpose: mutator method
		 */
		public void set(T newData) {
			data = newData;
		}
		
		/**
		 * method: get
		 * @return
		 * purpose: accessor method
		 */
		public T get() {
			return data;
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
