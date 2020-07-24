package lists;

public class ListArrayImplementation<T> {
	private int size;
	private int maxSize;
	private T[] listArray;
	
	public ListArrayImplementation() {
		this(10);
	}
	
	public ListArrayImplementation(int maxsize) {
		this.maxSize = maxsize;
		this.size = 0;
		this.listArray = (T[]) new Object[maxsize];
	}
	
	public int size() {
		return size;
	}
	
	public int maxSize() {
		return maxSize;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == maxSize;
	}
	
	public boolean append(T e) {
		if (isFull()) {
			return false;
		} else {
			listArray[size] = e;
			size++;
			return true;
		}
	}
	
	public boolean insert(T e, int pos) {
		if (isFull()) {
			return false;
		} else if (pos > maxSize-1) {
			return false;
		} else {
			for (int i=size; i > pos; i--) {
				listArray[i] = listArray[i-1];
			}
			listArray[pos] = e;
			size++;
			return true;
		}
	}
	
	public T get(int pos) {
		if (pos > maxSize-1) {
			throw new IndexOutOfBoundsException(pos + " is out of bounds");
		} else {
			return listArray[pos];
		}
	}
	
	public T remove(int pos) {
		if (pos > maxSize-1) {
			throw new IndexOutOfBoundsException(pos + " is out of bounds");
		} else {
			T element = get(pos);
			
			for (int i=pos; i<size-1; i++) {
				listArray[i] = listArray[i+1];
			}
			listArray[size-1] = null;
			size--;
			return element;
		}
	}
	
	public boolean contains(T e) {
		for (T each: listArray) {
			if (each == e) {
				return true;
			}
		}
		return false;
	}
}
