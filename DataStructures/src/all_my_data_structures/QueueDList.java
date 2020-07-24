package all_my_data_structures;

import lists.DoublyLinkedList;

public class QueueDList {
	private DoublyLinkedList queue;
	
	public QueueDList() {
		queue = new DoublyLinkedList();
	}
	
	public int size() {
		return queue.size();
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	public void enqueue(Object e) {
		queue.addLast(e);
	}
	
	public Object dequeue() {
		if (isEmpty()) {
			throw new EmptyQueueException("Queue is empty");
		} else {
			return queue.removeFirst().getElement();
		}
	}
	
	public Object front() {
		if (isEmpty()) {
			throw new EmptyQueueException("Queue is empty");
		} else {
			return queue.getFirst().getElement();
		}
	}
}
