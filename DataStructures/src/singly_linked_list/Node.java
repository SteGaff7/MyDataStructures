package singly_linked_list;

public class Node {
	private String element;
	private Node nextNode;
	
	public Node(String element, Node nextNode) {
		this.element = element;
		this.nextNode = nextNode;
	}
	
	public Node getNext() {
		return nextNode;
	}
	
	public void setNext(Node node) {
		nextNode = node;
	}
	
	public String getElement() {
		return element;
	}
}
