package all_my_data_structures;

import lists.SinglyLinkedList;

public class StackLinkedList2 {
	private SinglyLinkedList sList;
	
	public StackLinkedList2() {
		sList = new SinglyLinkedList();
	}
	
	public void push(Object e) {
		sList.addFirst(e);
	}
	
	public Object pop() {
		return sList.removeFirst();
	}
	
	public boolean isEmpty() {
		return sList.isEmpty();
	}
	
	public int size() {
		return sList.size();
	}
}
