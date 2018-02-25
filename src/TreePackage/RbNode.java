package TreePackage;

enum NodeColor{ RED, BLACK }

@SuppressWarnings("unused")
public class RbNode<T> extends BinaryNode<T> {
	private NodeColor color = NodeColor.BLACK;
	private RbNode<T> leftChild;
	private RbNode<T> rightChild;
	private T data;
	
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
}
