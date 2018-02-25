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
	
	private BinaryNode<T> findLargest(BinaryNode<T> rootNode){
		if(rootNode.hasRightChild()) {
			rootNode = findLargest(rootNode.getRightChild());
		}
		return rootNode;
	}
	
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
	@Override
	public boolean contains(T entry) {
		return getEntry(entry) != null;
	}

	@Override
	public T getEntry(T entry) {
		return findEntry(getRootNode(), entry);
	}

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

	@Override
	public T remove(T entry) {
		ReturnObject oldEntry = new ReturnObject();
		BinaryNode<T> newRoot = removeEntry(getRootNode(), entry, oldEntry);
		setRootNode(newRoot);
		return oldEntry.get();
	}
	
	/************ DISABLE BINARY TREE INTERFACE METHODS ************/
	public void setTree(T rootData) {
		throw new UnsupportedOperationException();
	}
	
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		throw new UnsupportedOperationException();
	}
	
	/************ INNER CLASSES ************/
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
