package all_my_data_structures;

public class SNode {
	
	private Object element;
	private SNode next;
	
	public SNode() {
		this(null, null);
	}
	
	public SNode(Object element, SNode next) {
		this.element = element;
		this.next = next;
	}
	
	public Object getElement() {
		return element;
	}
	
	public SNode getNext() {
		return next;
	}
	
	public void setElement(Object x) {
		element =x;
	}
	
	public void setNext(SNode x) {
		next = x;
	}

}
