package all_my_data_structures;

// Add tail functionality
public class LinkedListSingly {
	
	private int size;
	private SNode head;
//	private SNode tail;
	
	public LinkedListSingly() {
		size = 0;
		head = null;
//		tail = null;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void add(Object element) {
		SNode newNode = new SNode(element, null);
		
		if (isEmpty()) {
			head = newNode;
			size++;
		} else {
			// Last element point to this and this to null
			last().setNext(newNode);
			size++;
		}
	}
	
	public void addFirst(Object element) {
		SNode newNode = new SNode(element, null);
		
		if (isEmpty()) {
			head = newNode;
			size++;
		} else {
			newNode.setNext(head);
			head = newNode;
			size++;
		}
	}
	
	public void addLast(Object element) {
		
		add(element);
	}
	
	public void addAfter(SNode p, Object element) {
		
		SNode newNode = new SNode(element, null);
		
		newNode.setNext(p.getNext());
		p.setNext(newNode);
	}
	
	public Object removeFirst() {
		if (isEmpty()) {
			throw new RuntimeException("Is empty");
		} else {
			SNode temp = head;
			head = head.getNext();
			temp.setNext(null);
			size--;
			return temp.getElement();
		}
	}
	
	public SNode remove(SNode p) throws RuntimeException {
		
		if (isEmpty()) {
			// Add exception
			return null;
		}
		
		if (head == p) {
			SNode temp = head;
			head = head.getNext();
			temp.setNext(null);
			size--;
			return temp;
		} else {
			SNode prev = head;
			SNode current = head.getNext();
			
			for (int i=0; i < size-1; i++) {
				if (current == p) {
					prev.setNext(current.getNext());
					current.setNext(null);
					size--;
					return current;
				} else {
					prev = current;
					current = current.getNext();
				}
			}
		}

		// Change exception
		throw new RuntimeException("Node not found");
	}
	
	public void set(SNode p, Object element) {
		p.setElement(element);
	}
	
	public SNode next(SNode p) {
		return p.getNext();
	}
	
	public SNode last() {
		if (size() == 0) {
			// Throw error
			return null;
		} else {
			SNode last = head;
			for (int i=0; i < size - 1; i++) {
				last = last.getNext();
			}
			return last;
		}
	}
	
	public SNode first() {
		if (isEmpty()) {
			// Throw error
			return null;
		} else {
			return head;
		}
	}
	
}


//// function to sort a singly linked list using insertion sort 
//void insertionSort(node headref)  
//{ 
//    // Initialize sorted linked list 
//    sorted = null; 
//    node current = headref; 
//    // Traverse the given linked list and insert every 
//    // node to sorted 
//    while (current != null)  
//    { 
//        // Store next for next iteration 
//        node next = current.next; 
//        // insert current in sorted linked list 
//        sortedInsert(current); 
//        // Update current 
//        current = next; 
//    } 
//    // Update head_ref to point to sorted linked list 
//    head = sorted; 
//} 
//
///* 
// * function to insert a new_node in a list. Note that  
// * this function expects a pointer to head_ref as this 
// * can modify the head of the input linked list  
// * (similar to push()) 
// */
//void sortedInsert(node newnode)  
//{ 
//    /* Special case for the head end */
//    if (sorted == null || sorted.val >= newnode.val)  
//    { 
//        newnode.next = sorted; 
//        sorted = newnode; 
//    } 
//    else 
//    { 
//        node current = sorted; 
//        /* Locate the node before the point of insertion */
//        while (current.next != null && current.next.val < newnode.val)  
//        { 
//            current = current.next; 
//        } 
//        newnode.next = current.next; 
//        current.next = newnode; 
//    } 
//} 
