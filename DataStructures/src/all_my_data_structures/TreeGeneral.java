package all_my_data_structures;

import java.util.Iterator;


public class TreeGeneral<E extends Comparable<E>> implements Tree<E> {
	
//  MUST CHANGE ALL
	
	private int size;
	private NodeBinaryTree<E> root;
	
	public TreeGeneral() {
		this.size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public NodeBinaryTree<E> root() {
		return root;
	}

	@Override
	public NodeBinaryTree<E> parent(NodeBinaryTree<E> n) {
		return n.parent();
	}

	@Override
	public boolean isInternal(NodeBinaryTree<E> n) {
		return n.left() != null && n.right() != null;
	}

	@Override
	public boolean isExternal(NodeBinaryTree<E> n) {
		return n.left() == null && n.right() == null;
	}

	@Override
	public boolean isRoot(NodeBinaryTree<E> n) {
		return n == root;
	}

	@Override
	public NodeBinaryTree<E> replace(E e, NodeBinaryTree<E> n) {
		NodeBinaryTree<E> newNode = new NodeBinaryTree<E>(e);
		NodeBinaryTree<E> parent = n.parent();
		if (parent.left() == n) {
			parent.setChildLeft(newNode);
		} else if (parent.right() == n) {
			parent.setChildRight(newNode);
		}
		newNode.setChildLeft(n.left());
		newNode.setChildRight(n.right());
		
		n.setChildLeft(null);
		n.setChildRight(null);
		n.setParent(null);
		
		return n;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> positions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> children(NodeBinaryTree<E> p) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean hasLeft(NodeBinaryTree<E> n) {
		return n.left() != null;
	}
	
	public boolean hasRight(NodeBinaryTree<E> n) {
		return n.right() != null;
	}
	
	public NodeBinaryTree<E> left(NodeBinaryTree<E> n) {
		return n.left();
	}
	
	public NodeBinaryTree<E> right(NodeBinaryTree<E> n) {
		return n.right();
	}
	
	public void addRoot(E e) {
		NodeBinaryTree<E> r = new NodeBinaryTree<E>(e);
		if (isEmpty()) {
			root = r;
			root.setChildLeft(null);
			root.setChildRight(null);
			size++;
		} else {
			throw new RuntimeException("Root already exists");
		}
	}
	
	public void insertLeft(E e, NodeBinaryTree<E> n) {		
		if (n.left() == null) {
			NodeBinaryTree<E> newNode = new NodeBinaryTree<E>(e);
			newNode.setParent(n);
//			newNode.setChildLeft(null);
//			newNode.setChildRight(null);
			n.setChildLeft(newNode);
			size++;
		}
	}
	
	public void insertRight(E e, NodeBinaryTree<E> n) {		
		if (n.right() == null) {
			NodeBinaryTree<E> newNode = new NodeBinaryTree<E>(e);
			newNode.setParent(n);
//			newNode.setChildLeft(null);
//			newNode.setChildRight(null);
			n.setChildRight(newNode);
			size++;
		}
	}
	
	public NodeBinaryTree<E> remove(NodeBinaryTree<E> n) {
		
//		CHANGE IF I THINK
		
		if (n.left() != null && n.right() != null) {
			throw new RuntimeException("Node has 2 children");
		} else if (n.left() != null) {
//			Use left node to replace
			NodeBinaryTree<E> replacementNode = n.left();
			NodeBinaryTree<E> parent = n.parent();
			
			if (parent.left() == n) {
				parent.setChildLeft(replacementNode);
			} else if (parent.right() == n) {
				parent.setChildRight(replacementNode);
			}
			replacementNode.setParent(parent);
			n.setChildLeft(null);
			n.setParent(null);
			size--;
			return n;
			
		} else if (n.right() != null) {
//			Use right node to replace
			NodeBinaryTree<E> replacementNode = n.right();
			NodeBinaryTree<E> parent = n.parent();
			
			if (parent.left() == n) {
				parent.setChildLeft(replacementNode);
			} else if (parent.right() == n) {
				parent.setChildRight(replacementNode);
			}
			replacementNode.setParent(parent);
			n.setChildRight(null);
			n.setParent(null);
			size--;
			return n;
			
		} else {
//			Both null
			NodeBinaryTree<E> parent = n.parent();
			n.setParent(null);
			
			if (parent.left() == n) {
				parent.setChildLeft(null);
			} else if (parent.right() == n) {
				parent.setChildRight(null);
			}
			size--;
			return n;
		}
	}
	
	public void attach() {
		;
	}

		
	public void add(E e) {
		NodeBinaryTree<E> newNode = new NodeBinaryTree<E>(e);
		
		if (isEmpty()) {
			root = newNode;
			size++;
		} else {
			NodeBinaryTree<E> start = root;
			addRecursive(start, newNode);
		}
	}

	private void addRecursive(NodeBinaryTree<E> current, NodeBinaryTree<E> newNode) {
		int compareValue = newNode.element().compareTo(current.element());
		
		if(compareValue < 0) {
			if (current.left() != null) {
//				Recurse
				addRecursive(current.left(), newNode);
			} else {
//				Reassign
				current.setChildLeft(newNode);
				newNode.setParent(current);
				newNode.setChildLeft(null);
				newNode.setChildRight(null);
				size++;
			}
			
		} else if (compareValue > 0) {
			if (current.right() != null) {
				addRecursive(current.right(), newNode);
			} else {
				current.setChildRight(newNode);
				newNode.setParent(current);
				newNode.setChildLeft(null);
				newNode.setChildRight(null);
				size++;
			}
			
		} else {
			throw new RuntimeException("Duplicate values not allowed");
		}
	}
}
