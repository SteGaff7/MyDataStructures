package all_my_data_structures;


public class StackInfinite {
	
	private int stackSize;
	private int capacity;
	private Object[] stackArray;
	private int topIdxPointer;
	
	
	public StackInfinite() {
		stackSize = 0;
		capacity = 4;
		stackArray = new Object[capacity];
		topIdxPointer = 0;
	}
	
	public void push(Object x) {
		
		// If full then resize first
		if (isFull()) {
			resize();
			// Insert element, increase size, change pointer
			stackArray[topIdxPointer+1] = x;
			stackSize++;
			topIdxPointer++;
		} else if (isEmpty()) {
			// Look at again
			stackArray[topIdxPointer] = x;
			stackSize++;
			//checkTopIdxPointer();
		} else {
			// Insert element, increase size, change pointer
			stackArray[topIdxPointer+1] = x;
			stackSize++;
			topIdxPointer++;
			//checkTopIdxPointer();
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
			//checkTopIdxPointer();
			
			return x;
		}
	}
	
	public Object peek() throws EmptyStackException {
		
		if (! isEmpty()) {
			Object x = stackArray[topIdxPointer];
			return x;
		} else {
			throw new EmptyStackException("Stack is empty");
		}
		
	}
	
//	private void checkTopIdxPointer() {
//		if (topIdxPointer < 0) {
//			topIdxPointer += capacity;
//		} else if (topIdxPointer > capacity-1) {
//			topIdxPointer = topIdxPointer -capacity;
//		}
//	}
	
	public int size() {
		
		return stackSize;
	}
	
	public boolean isEmpty() {
		
		return stackSize == 0;
	}
	
	public boolean isFull() {
		
		return stackSize == capacity;
	}
	
	private void resize() {
		
		int newCapacity = 2*capacity;
		
		Object[] newArray = new Object[newCapacity];
		
		for (int i=0; i<capacity; i++) {
			newArray[i] = stackArray[i];
		}
		capacity = newCapacity;
		stackArray = newArray;
	}
}
