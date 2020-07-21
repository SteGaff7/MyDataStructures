package all_my_data_structures;

public class Hashtable {
	private int capacity;
	private int size;
	private VectorExtendableArray<LinkedListDoubly> array;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public Hashtable() {
		array = new VectorExtendableArray<LinkedListDoubly>();
		size = 0;
		capacity = array.capacity();
		
		for (int i=0; i < capacity; i++) {
			array.insertAtRank(i, new LinkedListDoubly());
		}
	}
	
	public String printLinkedList(Object k) {
		int hash = k.hashCode() % capacity;
		LinkedListDoubly linkedList = array.elemAtRank(hash);
		return linkedList.toString();
	}
	
	public boolean put(Object k, Object v) {
//		If resizing is needed, resize, rehash and then put entry in.
//		Else space is available and put entry in
		
		int hash = k.hashCode() % capacity;
		Entry entry = new Entry(k, v);
		
		LinkedListDoubly linkedList = array.elemAtRank(hash);
		
		try  {
			DNode node = linkedList.first();
			do {
				if (((Entry) node.getElement()).getKey() == k) {
//					Update value of key
					((Entry)node.getElement()).setValue(v);
					return true;
				} else {
					node = node.getNext();
				}
			} while (linkedList.hasNext(node.getNext()));
		
		} catch (IllegalStateException e) {
			linkedList.addLast(entry);
			size++;
			return true;
		}
		linkedList.addLast(entry);
		size++;
		return true;
	}

	
	public Object get(Object k) {
		int hash = k.hashCode() % capacity;
		LinkedListDoubly linkedList = array.elemAtRank(hash);
		
		try  {
			DNode node = linkedList.first();
			do {
				if (((Entry) node.getElement()).getKey() == k) {
					return ((Entry)node.getElement()).getValue();
				} else {
					node = node.getNext();
				}
				
			} while (linkedList.hasNext(node.getNext()));
			
			
		} catch (IllegalStateException e) {
//			throw exception
			return null;
		}
//		throw exception
		return null;
	}
	
	public Object remove(Object k) {
		int hash = k.hashCode() % capacity;
		LinkedListDoubly linkedList = array.elemAtRank(hash);
		
		try  {
			DNode node = linkedList.first();
			DNode prev = node;
			do {
				prev = node;
				if (((Entry) node.getElement()).getKey() == k) {
//					 remove node
					size--;
					return (((Entry) linkedList.remove(node).getElement()).getValue());
				} else {
					node = node.getNext();
				}
				
			} while (linkedList.hasNext(prev));
		} catch (IllegalStateException e) {
//			throw error
			return null;
		}
//		throw error
		return null;
	}
	
	public Entry[] entrySet() {
		Entry[] entrySet = new Entry[size()];
		System.out.println(entrySet.length);
		
//		Iterate each linked list
//		Get each DNode and then each entry from each
//		Store in entrySet
		
		int counter = 0;
		for(int i=0; i<capacity; i++) {
			LinkedListDoubly linkedList = array.elemAtRank(i);
			
			if (! linkedList.isEmpty()) {
				DNode node = linkedList.first();
				entrySet[counter] = (Entry) node.getElement();
				counter++;
						
				while (linkedList.hasNext(node.getNext())) {
					node = node.getNext();
					entrySet[counter] = (Entry) node.getElement();
					counter++;
				}
			}
		}
		return entrySet;
	}
	
	public Object[] keySet() {
		Object[] keySet = new Object[size()];
		
		int counter = 0;
		for(int i=0; i<capacity; i++) {
			LinkedListDoubly linkedList = array.elemAtRank(i);
			
			if (! linkedList.isEmpty()) {
				DNode node = linkedList.first();
				keySet[counter] = ((Entry) node.getElement()).getKey();
				counter++;
						
				while (linkedList.hasNext(node.getNext())) {
					node = node.getNext();
					keySet[counter] = ((Entry) node.getElement()).getKey();
					counter++;
				}
			}
		}

		return keySet;
	}
	
	public Object[] values() {
		Object[] values = new Object[size()];
		
		int counter = 0;
		for(int i=0; i<capacity; i++) {
			LinkedListDoubly linkedList = array.elemAtRank(i);
			
			if (! linkedList.isEmpty()) {
				DNode node = linkedList.first();
				values[counter] = ((Entry) node.getElement()).getValue();
				counter++;
						
				while (linkedList.hasNext(node.getNext())) {
					node = node.getNext();
					values[counter] = ((Entry) node.getElement()).getValue();
					counter++;
				}
			}
		}
		return values;
	}
	
	private boolean resize() {
		return true;
	}
	
	private boolean rehash() {
//		Use entry set tor ehash the whole hashtable 
		return true;
	}

}
