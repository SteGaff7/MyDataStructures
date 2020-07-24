package all_my_data_structures;

import lists.DoublyLinkedList;

public class DequeDList {
	private DoublyLinkedList deque;
	
	public DequeDList() {
		deque = new DoublyLinkedList();
	}
	
	public int size() {
		return deque.size();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public Object front() {
		if (isEmpty()) {
			throw new EmptyDequeException("Deque is empty");
		} else {
			return deque.getFirst().getElement();
		}
	}
	
	public Object rear() {
		if (isEmpty()) {
			throw new EmptyDequeException("Deque is empty");
		} else {
			return deque.last().getElement();
		}
	}
	
	public void insertFirst(Object e) {
		deque.addFirst(e);
	}
	
	public void insertLast(Object e) {
		deque.addLast(e);
	}
	
	public Object removeFirst() {
		if (isEmpty()) {
			throw new EmptyDequeException("Deque is empty");
		} else {
			return deque.removeFirst().getElement();
		}
	}
	
	public Object removeLast() {
		if (isEmpty()) {
			throw new EmptyDequeException("Deque is empty");
		} else {
			return deque.removeLast().getElement();
		}
	}
}
