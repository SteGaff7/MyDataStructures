package all_my_data_structures;

import java.util.ArrayList;

public class Heap {
	private ArrayList<Integer> heapArray;
	private int size;
	
	public Heap() {
		heapArray = new ArrayList<Integer>();
		size = 0;
	}
	
	public Heap(ArrayList<Integer> arr) {
//		Trusted heap array setup
		heapArray = arr;
		size = arr.size();
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void insert(int x) {
		
		if (isEmpty()) {
			heapArray.add(0, Integer.MIN_VALUE);
			heapArray.add(1, x);
			size = 2;
			return;
		}
		
		heapArray.add(size, x);
//		Check heap-order
		recurUpheap(size);
		size++;
	}
	
	public int remove() {
		if (size > 2) {
			int temp = heapArray.get(1);
			heapArray.set(1, heapArray.get(size-1));
			heapArray.set(size-1, temp);
			heapArray.remove(size-1);
			size--;
			recurDownheap(1);
			return temp;
			
		} else if (size == 2){
			int element = heapArray.remove(size-1);
			size = 0;
			return element;
		} else {
			throw new RuntimeException("Heap is empty");
		}
	}
	
	private void recurDownheap(int idx) {
		int value = heapArray.get(idx);
		
		if (idx*2 > size-1) {
//			If no more children
			return;
		} else if ((idx*2) +1 > size-1) {
//			If just left child
			int childLeft = heapArray.get(idx*2);
			if (value > childLeft) {
				heapArray.set(idx, childLeft);
				heapArray.set(idx*2, value);
				recurDownheap(idx*2);
			} else {
				return;
			}	
		} else {
//			Otherwise both children
			int childLeft = heapArray.get(idx*2);
			int childRight = heapArray.get((idx*2)+1);
			
			if (value <= childLeft && value <= childRight) {
				return;
			}
			
			if (value > childLeft && !(value > childRight)) {
//				Replace left
				heapArray.set(idx, childLeft);
				heapArray.set(idx*2, value);
				recurDownheap(idx*2);
				
			} else if (value > childRight && !(value > childLeft)) {
//				Replace right
				heapArray.set(idx, childRight);
				heapArray.set((idx*2)+1, value);
				recurDownheap((idx*2)+1);
			} else if (value > childLeft && value > childRight) {
				if (childLeft <= childRight) {
//					Replace left
					heapArray.set(idx, childLeft);
					heapArray.set(idx*2, value);
					recurDownheap(idx*2);
				} else {
//					Replace right
					heapArray.set(idx, childRight);
					heapArray.set((idx*2)+1, value);
					recurDownheap((idx*2)+1);
				}
			}		
		}
	}

	
	private void recurUpheap(int idx) {
//		Add case when == root

		int value = heapArray.get(idx);

		int parent = heapArray.get(idx/2);

		if (value >= parent) {
//			Do nothing
			return;
		} else {
//			Swap and recur again
			heapArray.set(idx/2, value);
			heapArray.set(idx, parent);
			recurUpheap(idx/2);
		}
	}
	
	public void print() {
		System.out.println(heapArray.toString());
	}
}
