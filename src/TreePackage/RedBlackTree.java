package TreePackage;

public class RedBlackTree<T> implements BinaryTreeInterface<T> {
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
