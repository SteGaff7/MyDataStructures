package all_my_data_structures;

import lists.DoublyLinkedList;
import lists.ListArrayImplementation;

public class Hashtable2 {
	private int size;
	private int maxSize;
	private ListArrayImplementation<DoublyLinkedList> array;
	
	public Hashtable2() {
		this.array = new ListArrayImplementation<DoublyLinkedList>();
		this.maxSize =array.maxSize();
		this.size = 0;
		
		for (int i=0; i<maxSize; i++) {
			array.insert(new DoublyLinkedList(), i);
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void printArrayContents() {
		System.out.println(maxSize);
		for (int i=0; i<maxSize-1; i++) {
			System.out.println(array.get(i) == array.get(i+1));
		}
	}
}
