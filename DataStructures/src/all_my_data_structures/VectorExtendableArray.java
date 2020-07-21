package all_my_data_structures;

/**
 * V similar to a list array implemented
 */

public class VectorExtendableArray<T> {
	private int capacity;
	private int size;
	private T[] array;
	
	
	public VectorExtendableArray() {
		this(10);
	}
	
	public VectorExtendableArray(int capacity) {
		this.capacity = capacity;
		this.array = (T[]) new Object[capacity];
		this.size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public int capacity() {
		return capacity;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public boolean isFull() {
		return size() == capacity();
	}
	
	public T elemAtRank(int r) {
		if (r > size+1 || r < 0) {
			throw new RuntimeException("Rank is outside array length");
		}
		return array[r];
	}
	
	public T replaceAtRank(int r, T e) {
		if (r > size+1 || r < 0) {
			throw new RuntimeException("Rank is outside array length");
		}
		T original = array[r];
		array[r] = e;
		return original;
	}
	
	public boolean insert(T e) {
		if (isFull()) {
			resizeArray();			
		}
		array[size] = e;
		size++;
		return true;
	}
	
	public boolean insertAtRank(int r, T e) {
		if (r > size+1 || r < 0) {
			throw new RuntimeException("Rank is outside array length");
		}
		if (isFull()) {
			resizeArray();
		}
		T insert = e;
		for (int i=r; i <= size; i++) {
			T temp = array[i];
			array[i] = insert;
			insert = temp;
		}
		size++;
		return true;
	}
	
	public void resizeArray() {
		int newCapacity = capacity*2;
		T[] newArray = (T[]) new Object[newCapacity];
		
		for (int i=0; i<array.length; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
		capacity = newCapacity;
	}
	
	public T removeAtRank(int r) {
		if (r > size-1 || r < 0) {
			throw new RuntimeException("Rank is outside array length");
		} else {
			T element = array[r];
			for (int i=r; i<size-1; i++) {
				array[i] = array[i+1];
			}
			array[size-1] = null;
			size--;
			return element;
		}
	}
}
