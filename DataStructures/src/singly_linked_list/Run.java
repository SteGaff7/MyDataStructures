package singly_linked_list;

public class Run {

	public static void main(String[] args) throws Exception {
		
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.addNode("a");
		list.addNode("b");
		list.addNode("c");
		list.addNode("h");
		list.addNodeFirst("first");
		list.addNodeLast("last");
		list.deleteFirstNode();
		list.deleteNode("c");
		list.deleteNode("last");
		list.addNodeAfter("x", "b");
		
//		try {
//			System.out.println("Retrieved: " + list.getNode("x").getElement());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		list.printNodes();

	}

}
