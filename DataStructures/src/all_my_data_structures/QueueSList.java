package all_my_data_structures;

public class QueueSList {
	private LinkedListSingly queue;
	
	public QueueSList() {
		queue = new LinkedListSingly();
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
