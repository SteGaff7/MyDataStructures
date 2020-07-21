package all_my_data_structures;

public class LinkedListDoubly {
	
	private int size; 
	private DNode header, trailer;
	
	public LinkedListDoubly() {
		size = 0;
		header = new DNode(null, null, null);
		trailer = new DNode(null, header, null);
		header.setNext(trailer);
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public DNode first() {
		
		if (isEmpty()) {
			throw new IllegalStateException("List is empty");
		} else {
			return header.getNext();
		}
	}
	
	public DNode last() {
		if (isEmpty()) {
			throw new IllegalStateException("List is empty");
		} else {
			return trailer.getPrev();
		}
	}
	
	public void set(DNode node, Object element) {
		node.setElement(element);
	}
	
	public void addFirst(Object element) {
		DNode newNode = new DNode(element, null, null);
		
		newNode.setNext(header.getNext());
		header.getNext().setPrev(newNode);
		newNode.setPrev(header);
		header.setNext(newNode);
		size++;
	}
	
	public void addLast(Object element) {
		DNode newNode = new DNode(element, null, null);
		
		newNode.setNext(trailer);
		newNode.setPrev(trailer.getPrev());
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);		
		size++;
	}
	
	public void addBefore(DNode n, Object element) {
		DNode newNode = new DNode(element, null, null);
		
		if (n == header) {
			throw new IllegalArgumentException("Cannot ahead before the header");
		} else {
			newNode.setNext(n);
			newNode.setPrev(n.getPrev());
			n.getPrev().setNext(newNode);
			n.setPrev(newNode);
			size++;
		}
	}
	
	public void addAfter(DNode n, Object element) {
		DNode newNode = new DNode(element, null, null);
		
		if (n == trailer) {
			throw new IllegalArgumentException("Cannot ahead after the trailer");
		} else {
			newNode.setNext(n.getNext());
			newNode.setPrev(n);
			n.getNext().setPrev(newNode);
			n.setNext(newNode);
			size++;			
		}
	}
	
	public DNode getFirst() {
		if (! isEmpty()) {
			return header.getNext();
		} else {
			throw new IllegalStateException("List is empty");
		}
	}
	
	public DNode getLast() {
		if (! isEmpty()) {
			return trailer.getPrev();
		} else {
			throw new IllegalStateException("List is empty");
		}
	}
	
	public DNode getPrev(DNode n) {
		if (n == header) {
			throw new IllegalArgumentException("No node before header");
		} else {
			return n.getPrev();
		}
	}
	
	public DNode getNext(DNode n) {
		if (n == trailer) {
			throw new IllegalArgumentException("No node after trailer");
		} else {
			return n.getNext();
		}
	}
	
	public DNode remove(DNode n) {
		if (n == header || n == trailer) {
			throw new IllegalArgumentException("Cannot remove special nodes");
		} else {
			n.getPrev().setNext(n.getNext());
			n.getNext().setPrev(n.getPrev());
			n.setNext(null);
			n.setPrev(null);
			size--;
			return n;
		}
	}
	
	public DNode removeFirst() {
		if (size() == 0) {
			throw new IllegalStateException("List is empty");
		} else {
			DNode temp = header.getNext();
			header.setNext(temp.getNext());
			temp.getNext().setPrev(header);
			temp.setNext(null);
			temp.setPrev(null);
			size--;
			return temp;
		}
	}
	
	public DNode removeLast() {
		if (size() == 0) {
			throw new IllegalStateException("List is empty");
		} else {
			DNode temp = trailer.getPrev();
			trailer.setPrev(temp.getPrev());
			temp.getPrev().setNext(trailer);
			temp.setNext(null);
			temp.setPrev(null);
			size--;
			return temp;
		}
	}
	
	public String toString() {
		int counter = 0;
		String str = "";
		DNode node = header.getNext();
		
		while (counter < size)  {
			str+= node.getElement();
			str+="/n";
			counter++;
			node = node.getNext();
		}
		return str;
	}
	
	public boolean hasNext(DNode n) {
		return n != trailer;
	}
	
	public boolean hasPrev(DNode n) {
		return n != header;
	}
	
	//INSERTION SORT
	
	public void insertionSort() {
		
		DNode header2 = new DNode(null, null, null);
		DNode trailer2 = new DNode(null, header2, null);
		header2.setNext(trailer2);
		
		DNode insertionNode = removeFirst();
		int newSize = 1;
		
		header2.setNext(insertionNode);
		trailer2.setPrev(insertionNode);
		insertionNode.setPrev(header2);
		insertionNode.setNext(trailer2);
		
		for (int i=1; i<newSize+size; i++) {
			insertionNode = removeFirst();
			int element = (int) insertionNode.getElement();
			
			DNode comparisonNode = trailer2.getPrev();
			
			for (int j=0; j<newSize; j++) {
				int comparisonElement = (int) comparisonNode.getElement();
				if (element >= comparisonElement) {
					break;
				} else {
					comparisonNode = comparisonNode.getPrev();
				}
			}
			
			DNode after = comparisonNode.getNext();
			
			insertionNode.setNext(after);
			insertionNode.setPrev(comparisonNode);
			after.setPrev(insertionNode);
			comparisonNode.setNext(insertionNode);
			newSize++;			
		}
		
		header = header2;
		trailer = trailer2;
		size = newSize;
	}
}	
