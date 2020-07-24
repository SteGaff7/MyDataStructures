package all_my_data_structures;

import lists.SNode;

public class StackLinkedList {
	private SNode head;
	private int size;
	
	public StackLinkedList() {
		head = new SNode(null, null);
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void push(Object e) {
		SNode newNode = new SNode(e, null);
		if (isEmpty()) {
			head.setNext(newNode);
			size++;
		} else {
			newNode.setNext(head.getNext());
			head.setNext(newNode);
			size++;
		}
	}
	
	public Object pop() {
		if (isEmpty()) {
			throw new EmptyStackException("Stack is empty");
		} else {
			SNode first = head.getNext();
			Object e = first.getElement();
			head.setNext(first.getNext());
			first.setNext(null);
			size--;
			return e;
		}
	}
	
	public Object peek() {
		if (isEmpty()) {
			throw new EmptyStackException("Stack is empty");
		} else {
			SNode first = head.getNext();
			Object e = first.getElement();
			return e;
		}
	}

}
