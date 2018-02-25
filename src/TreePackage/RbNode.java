package TreePackage;

enum NodeColor{ RED, BLACK }

public class RbNode<T> extends BinaryNode<T> {
	private NodeColor color = NodeColor.BLACK;
	
	public NodeColor getNodeColor() {
		return color;
	}
}
