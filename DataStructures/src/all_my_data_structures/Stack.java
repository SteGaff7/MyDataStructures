package all_my_data_structures;

public class Stack {
	
	private int stackSize;
	private int capacity;
	private Object[] stackArray;
	private int topIdxPointer;
	
	
	public Stack() {
		this(10);
	}
	
	public Stack(int capacity) {
		this.capacity = capacity;
		stackSize = 0;
		stackArray = new Object[capacity];
		topIdxPointer = 0;
	}
	
	public void push(Object x) throws FullStackException {
		
		// If full then resize first
		if (isFull()) {
			throw new FullStackException("Stack if full");
		} else if (isEmpty()) {
			// Look at again
			stackArray[topIdxPointer] = x;
			stackSize++;
			
		} else {
			// Insert element, increase size, change pointer
			stackArray[topIdxPointer+1] = x;
			stackSize++;
			topIdxPointer++;
			
		}
	}
	
	public Object pop() throws EmptyStackException {
		
		if (isEmpty()) {
			throw new EmptyStackException("Stack is empty");
		} else {
			Object x = stackArray[topIdxPointer];
			stackArray[topIdxPointer] = null;
			stackSize--;
			topIdxPointer--;
			return x;
		}
	}
	
	public Object peek() throws EmptyStackException {
		
		if (isEmpty()) {
			throw new EmptyStackException("Stack is empty");
		} else {
			Object x = stackArray[topIdxPointer];
			return x;
		}
	}

	
	public int size() {
		
		return stackSize;
	}
	
	public boolean isEmpty() {
		
		return stackSize == 0;
	}
	
	public boolean isFull() {
		
		return stackSize == capacity;
	}
}
