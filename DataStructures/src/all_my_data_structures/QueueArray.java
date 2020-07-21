package all_my_data_structures;

public class QueueArray {
	private int front, rear, size, capacity;
	private Object[] queue;
	
	public QueueArray() {
		this(10);
	}
	
	public QueueArray(int capacity) {
		this.capacity = capacity;
		this.queue = new Object[this.capacity];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public boolean isFull() {
		return size == capacity;
	}
	
	public Object front() {
		if (isEmpty()) {
			throw new EmptyQueueException("Queue is empty");
		} else {
			return queue[front];
		}
	}
	
	public void enqueue(Object e) {
		if (isFull()) {
			throw new FullQueueException("Queue is full");
		} else {
			queue[rear] = e;
			rear = (rear+1) % capacity;
			size++;
		}
	}
	
	public Object dequeue() {
		if (isEmpty()) {
			throw new EmptyQueueException("Queue is empty");
		} else {
			Object element = queue[front];
			queue[front] = null;
			front = (front+1) % capacity;
			size--;
			return element;
		}
	}
	
	public void print() {
		for (int i=0; i<capacity;i++) {
			System.out.println(queue[i]);
		}
	}

}
