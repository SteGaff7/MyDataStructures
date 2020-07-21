package all_my_data_structures;

public class NodeBinaryTree<O> implements NodeTree<NodeBinaryTree<O>, O>{
	private NodeBinaryTree<O> parent, childLeft, childRight;
	private O element;
	
	public NodeBinaryTree (O element) {
		this(element, null, null, null);
	}
	
	public NodeBinaryTree (O element, NodeBinaryTree<O> p) {
		this(element, p, null, null);
	}
	
	public NodeBinaryTree(O element, NodeBinaryTree<O> p, NodeBinaryTree<O> l, NodeBinaryTree<O> r) {
		this.element = element;
		this.parent = p;
		this.childLeft = l;
		this.childRight = r;
	}
	
	public O element() {
		return element;
	}
	
	public NodeBinaryTree<O> parent() {
		return parent;
	}
	
	public NodeBinaryTree<O> left() {
		return childLeft;
	}
	
	public NodeBinaryTree<O> right() {
		return childRight;
	}
	
	public void setElement(O e) {
		this.element = e;
	}
	
	public void setParent(NodeBinaryTree<O> p) {
		this.parent = p;
	}
	
	public void setChildLeft(NodeBinaryTree<O> n) {
		this.childLeft = n;
	}
	
	public void setChildRight(NodeBinaryTree<O> n) {
		this.childRight = n;
	}
}
