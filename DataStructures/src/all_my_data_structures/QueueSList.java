package all_my_data_structures;

import lists.SinglyLinkedList;

public class QueueSList {
	private SinglyLinkedList queue;
	
	public QueueSList() {
		queue = new SinglyLinkedList();
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
			return queue.removeFirst();
		}
	}
	
	public Object front() {
		if (isEmpty()) {
			throw new EmptyQueueException("Queue is empty");
		} else {
			return queue.first().getElement();
		}
	}

}
