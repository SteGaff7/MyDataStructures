package all_my_data_structures;

public class StackLinkedList2 {
	private LinkedListSingly sList;
	
	public StackLinkedList2() {
		sList = new LinkedListSingly();
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
