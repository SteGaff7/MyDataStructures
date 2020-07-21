package singly_linked_list;

public class SinglyLinkedList {
	private int size;
	private Node head;
	private Node tail;
	
	public SinglyLinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	public void addNode(String element) {
		Node newNode = new Node(element, null);
		
		if (size == 0) {
			head = newNode;
			tail = newNode;
			size++;
			
		} else {
			tail.setNext(newNode);
			tail = newNode;
			size++;
		}
	}
	
	public void addNodeFirst(String element) {
		Node newNode = new Node(element, null);
		
		newNode.setNext(head);
		head = newNode;
		size++;
		
	}
	
	// OBSELOTE - Does anyway?
	public void addNodeLast(String element) {
		Node newNode = new Node(element, null);
		
		tail.setNext(newNode);
		tail = newNode;
		size++;
	}
	
	public void addNodeAfter(String element, String key) throws Exception {
		Node newNode = new Node(element, null);
		Node currentNode = head;
		Node prevNode = getNode(key);
		
		for (int i=0; i < size; i++) {
			if (currentNode == prevNode) {
				newNode.setNext(currentNode.getNext());
				currentNode.setNext(newNode);
				size++;
				return;
			} else {
				currentNode = currentNode.getNext();
			}
		}
	}
	
	public Node getNode(String key) throws Exception {
		Node currentNode = head;

		for (int i=0; i < size; i++) {
			if (currentNode.getElement() == key) {
				return currentNode;
			} else {
				currentNode = currentNode.getNext();
			}
		}
		
		throw new Exception("Key not found");
	}
	
	
	public void deleteFirstNode() {
		
		Node temp = head.getNext();
		head.setNext(null);
		head = temp;
		size--;
		
	}
	
	public void deleteNode(String key) throws Exception {
		Node deleteNode = getNode(key);
		
//		if (tail == deleteNode) {
//			// Call special delete last node method
//			deleteLastNode(); 
//		} else {
		
		// Seems to work for last node too
		Node currentNode = head;
		
		for (int i=0; i < size; i++) {
			
			if (currentNode.getNext() == deleteNode) {
				
				currentNode.setNext(deleteNode.getNext());
				deleteNode.setNext(null);
				size--;
				if (deleteNode == tail) {
					tail = currentNode;
				}
				return;
			} else {
				currentNode = currentNode.getNext();
			}
		}
		return;
			
//		}
	}
	
	
	public void printNodes() {
		Node currentNode = head;
		
		for (int i=0; i < size; i++) {
			System.out.println(currentNode.getElement());
			currentNode = currentNode.getNext();
		}
	}

}
