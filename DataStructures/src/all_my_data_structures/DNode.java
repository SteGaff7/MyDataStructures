package all_my_data_structures;

public class DNode {
	
	private Object element;
	private DNode next, prev;
	
	public DNode() {
		this(null, null, null);
	}
	
	public DNode(Object element, DNode prev, DNode next) {
		this.element = element;
		this.prev = prev;
		this.next = next;
	}
	
	public void setElement(Object element) {
		this.element= element;
	}
	
	public void setNext(DNode n) {
		this.next = n;
	}
	
	public void setPrev(DNode p) {
		this.prev = p;
	}
	
	public Object getElement() {
		return element;
	}
	
	public DNode getNext() {
		return next;
	}
	
	public DNode getPrev() {
		return prev;
	}

}
