package all_my_data_structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestClass {

	public static void main(String[] args) {
		
//		StackInfinite myStack = new StackInfinite();
//		
//		// System.out.println();
//		
//		myStack.push("a");
//		myStack.push(2);
//		myStack.push(3);
//		myStack.push(4);
//		myStack.push(5);
//		System.out.println(myStack.size());
//		myStack.pop();
//		myStack.pop();
//		myStack.pop();
//		myStack.pop();
//		myStack.pop();
//		
//		System.out.println(myStack.isEmpty());
//		System.out.println(myStack.isFull());
//		
		
//		SinglyLinkedList SList = new SinglyLinkedList();
//		
//		SList.add("String1");
//		SList.add("String2");
//		SList.add(2);
//		
//		System.out.println(SList.first().getElement());
//		System.out.println(SList.last().getElement());
//		
//		System.out.println(SList.size());
//		System.out.println(SList.isEmpty());
		
//		SNode c = new SNode("c", null);
//		SNode b = new SNode("b", c);
//		SNode a = new SNode("a", b);
		
//		SNode prev = a;
//		SNode current = b;
//		
//		prev = current;
//		current = current.getNext();
//		
//		System.out.println(prev.getElement());
//		System.out.println(current.getElement());
		
//		SNode head = a;
//		SNode temp = head;
//		head = head.getNext();
//		temp.setNext(null);
//		
//		System.out.println(temp.getElement());
//		System.out.println(head.getElement());
		
		
//		LINKED LIST - DOUBLY
		
//		LinkedListDoubly list = new LinkedListDoubly();
//		
//		list.addLast(100);
//		list.addLast(5);
//		list.addLast(220);
//		list.addLast(1100);
//		list.addLast(740);
//		list.addLast(1);
//		
//		list.insertionSort();
//		
//		System.out.println(list.size());
//		System.out.println(list.removeFirst().getElement());
//		System.out.println(list.removeFirst().getElement());
//		System.out.println(list.removeFirst().getElement());
//		System.out.println(list.removeFirst().getElement());
//		System.out.println(list.removeFirst().getElement());
//		System.out.println(list.removeFirst().getElement());

		
//		System.out.println(list.toString());
		
		
//		LIST - ARRAY IMPLEMENTATION
		
//		ListArrayImplementation<Integer> myList = new ListArrayImplementation<Integer>();
//		myList.append(0);
//		System.out.println(myList.contains(0));
//		System.out.println(myList.get(0));
//		for (int i=1; i<10; i++) {
//			myList.append(i);
//		}
//		for (int i=0; i<10; i++) {
//			System.out.println(myList.get(i));
//		}
//		
//		System.out.println("**** "+myList.get(9));
//		myList.remove(9);
//		myList.insert(10, 2);
//		for (int i=0; i<10; i++) {
//			System.out.println(myList.get(i));
//		}
//		System.out.println(myList.size());
		
		
		
//		STACK - LINKED LIST IMPLEMENTATION
//		
//		StackLinkedList myStack = new StackLinkedList();
//		
//		
//		myStack.push("a");
//		
//		System.out.println(myStack.pop());
//		System.out.println(myStack.size());
//		
//		
//		myStack.push("b");
//		myStack.push("c");
//		myStack.push("d");
//		System.out.println(myStack.size());
//		
//		System.out.println(myStack.pop());
//		System.out.println(myStack.pop());
//		System.out.println(myStack.pop());
//		System.out.println(myStack.pop());
		
		
//		VECTOR - EXTENDABLE ARRAY 
//		
//		VectorExtenableArray myVector = new VectorExtenableArray(4);
//		System.out.println(myVector.capacity());
//		myVector.insert(0);
//		myVector.insert(1);
//		myVector.insert(2);
//		myVector.insert(3);
//		System.out.println(myVector.capacity());
//		myVector.insert(4);
//		System.out.println(myVector.capacity());
//		myVector.insert(5);
//		
//		
//		System.out.println("*" + myVector.elemAtRank(3));
//		System.out.println("*" + myVector.elemAtRank(1));
//		System.out.println("*" + myVector.elemAtRank(6));
//		myVector.insertAtRank(6, 100);
//		System.out.println("*" + myVector.elemAtRank(6));
//		myVector.removeAtRank(6);
//		System.out.println("*" + myVector.elemAtRank(6));
		
		
//		QUEUE - SLIST
		
//		QueueSList queue = new QueueSList();
//		
//		queue.enqueue(12);
//		queue.enqueue(13);
//		queue.enqueue(14);
//		queue.enqueue(15);
//		System.out.println(queue.front());
//		System.out.println(queue.dequeue());
//		System.out.println(queue.dequeue());
//		System.out.println(queue.size());
		
		
//		QUEUE - DLIST
		
//		QueueDList queue = new QueueDList();
//		
//		queue.enqueue(12);
//		queue.enqueue(13);
//		queue.enqueue(14);
//		queue.enqueue(15);
//		System.out.println(queue.front());
//		System.out.println(queue.dequeue());
//		System.out.println(queue.dequeue());
//		System.out.println(queue.size());
		
		
//		QUEUE - ARRAY
		
//		QueueArray queue = new QueueArray(4);
//		
//		queue.enqueue("a");
//		queue.enqueue("b");
//		queue.enqueue("c");
//		queue.enqueue("d");
//		System.out.println();
//		queue.print();
//		System.out.println();
//		
//		System.out.println(queue.dequeue());
//		
//		System.out.println();
//		queue.print();
//		System.out.println();
//		
//		queue.enqueue("x");
//		
//		System.out.println();
//		queue.print();
//		System.out.println();
//		
//		System.out.println(queue.dequeue());
//		System.out.println(queue.size());
//		System.out.println(queue.dequeue());
//		System.out.println(queue.dequeue());
//		System.out.println(queue.dequeue());
//		queue.enqueue("a");
//		System.out.println(queue.dequeue());
		
//		DEQUE - LINKED LIST
		
//		DequeDList deque = new DequeDList();
//		
//		deque.insertFirst(0);
//		deque.insertLast(1);
//		deque.insertFirst(4);
//		deque.insertLast(7);
//		
//		System.out.println(deque.removeFirst());
//		System.out.println(deque.removeLast());
//		System.out.println(deque.removeLast());
//		System.out.println(deque.removeLast());
		
//		LinkedList list = new LinkedList();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//		
//		Iterator itr = list.iterator();
//		
//		while (itr.hasNext()) {
//			Object a = itr.next();
//			
//			if (a == (Object) 2) {
//				itr.remove();
//			}
//		}
//		
//		for (Object e : list) {
//			System.out.println(e);
//		}
		
		
//		BINARY TREE - LIST
		
//		BinaryTreeLinked tree = new BinaryTreeLinked();
//		
//		System.out.println(tree.size());
//		System.out.println(tree.isEmpty());
//		System.out.println();
//		
//		tree.add(12);
//		tree.add(17);
//		tree.add(7);
//		tree.add(21);
//		
//		NodeBinaryTree root = tree.root();
//		System.out.println(root.element());
//		System.out.println(root.left().element());
//		System.out.println(root.right().element());
//		System.out.println(root.right().right().element());
//		System.out.println("Internal: " + tree.isInternal(root.right().right()));
//		System.out.println("External: " + tree.isExternal(root.right().right()));
//		System.out.println("Root Internal: " + tree.isInternal(root));
//		System.out.println("Root External: " + tree.isExternal(root));
//		System.out.println("Root is root: " + tree.isRoot(root));
//		System.out.println("Node is root: " + tree.isRoot(root.left()));
////		System.out.println(root.right().left().element());
//		System.out.println();
//		
//		System.out.println(tree.size());
//		System.out.println(tree.isEmpty());
//		System.out.println();
		
		
		
//		PROPER BINARY TREE - LIST
		
//		BinaryTreeLinked tree = new BinaryTreeLinked();
//		
//		System.out.println(tree.size());
//		System.out.println(tree.isEmpty());
//		System.out.println();
//		
//		tree.add(50);
//		tree.add(30);
//		tree.add(20);
//		tree.add(40);
//		tree.add(70);
//		tree.add(60);
//		tree.add(80);
//		
//		System.out.println("Height: " + tree.getHeight());
//		System.out.println("Min value: " + tree.min().element());
//		
//		tree.remove(tree.search(40));
//		
//		tree.printTree();
//		
////		NodeBinaryTree root = tree.root();
////		System.out.println(root.element());
////		System.out.println(tree.search(7).element());
//		
////		tree.remove(tree.search(17));
////		System.out.println(tree.search(21).parent().element());
//////		System.out.println(tree.search(17).element());
//		
//		System.out.println();
//		System.out.println(tree.traverseInOrder().toString());
//		
//		BinaryTreeLinked<String> tree3 = new BinaryTreeLinked<String>();
//		
//		tree3.add("J");
//		tree3.add("D");
//		tree3.add("F");
//		tree3.add("B");
//		tree3.add("X");
//		tree3.add("V");
//		tree3.add("C");
////		
////		System.out.println(tree3.search("X").right().element());
//		
//		System.out.println(tree3.traverseInOrder().toString());
//		System.out.println(tree3.traverseAlternative().toString());
//		System.out.println("Height: " + tree3.getHeight());
//		System.out.println("Min value: " + tree3.min().element());
//		
//		tree3.remove(tree3.search("D"));
//		tree3.printTree();
		
//		BinaryTreeLinked<Integer> tree4 = new BinaryTreeLinked<Integer>();
//		
//		tree4.add(6);
//		tree4.add(2);
//		tree4.add(1);
//		tree4.add(9);
//		tree4.add(8);
//		tree4.add(15);
//		tree4.add(13);
//		tree4.add(18);
//		tree4.add(11);
////		tree4.add(27);
////		tree4.add(16);
//		tree4.remove(tree4.search(6));
//		tree4.remove(tree4.search(15));
//		
//		tree4.printTree();

//		HEAP - VECTOR IMPLEMENTATION
		
		
//		ArrayList<Integer> arr = new ArrayList<Integer>();
//		
//		Integer[] c = {Integer.MIN_VALUE,10,15,30,40,50,100,40,80};
//		
//		arr.addAll(Arrays.asList(c));
//		
//		System.out.println(arr.toString());
//		
//		Heap heap = new Heap(arr);
//		
////		heap.insert(20);
////		heap.insert(30);
////		
////		heap.insert(10);
////		heap.insert(1000);
////		heap.insert(120);
////		heap.insert(20);
////		heap.insert(50);
////		heap.insert(70);
////		heap.insert(70);
////		heap.insert(5);
//		
//		heap.remove();
//		heap.remove();
//		heap.print();
//		
//		Heap heap2 = new Heap();
//		
//		
//		heap2.insert(20);
//		heap2.insert(40);
//		heap2.insert(15);
//		heap2.remove();
//		heap2.insert(100);
//		heap2.insert(4);
//		
//		heap2.print();
		
//		MAP - HASTABLE IMPLEMENTAION
		
		Hashtable hashtable = new Hashtable();
		hashtable.put(6, "a");
		hashtable.put(8, "b");
		hashtable.put(6, "A");
		hashtable.put(6, "A");
		hashtable.put("a", "x");
		hashtable.put("z", 26);
		hashtable.put(6, "A");
		
//		hashtable.remove("z");
		
		
////		hashtable.put(6, "c");	
//		System.out.println(hashtable.get(6));
////		System.out.println(hashtable.remove(6));
//		System.out.println(hashtable.get(6));
////		hashtable.put(6, "a");
//		System.out.println(hashtable.get(6));
////		System.out.println(hashtable.remove(6));
//		System.out.println(hashtable.get(8));
//		System.out.println(hashtable.printLinkedList(6));
		
		Entry[] entrySet = hashtable.entrySet();
		
		for (Entry e: entrySet) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}
		
		Object[] keySet = hashtable.keySet();
		
		for (Object e: keySet) {
			System.out.println(e);
		}
		
		Object[] values = hashtable.values();
		
		for (Object e: values) {
			System.out.println(e);
		}

	}

}
