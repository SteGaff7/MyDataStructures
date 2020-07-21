package all_my_data_structures;

import java.util.ArrayList;
import java.util.Iterator;

public class BinaryTreeLinked<E extends Comparable<E>> implements Tree<E> {
	
	private int size;
	private NodeBinaryTree<E> root;
	
	public BinaryTreeLinked() {
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
			size = 3;
		} else {
			throw new RuntimeException("Root already exists");
		}
	}
	
	public void insertLeft(NodeBinaryTree<E> node, E e) {		
		if (node.left() == null) {
//			Create new node with parent node
			NodeBinaryTree<E> newNode = new NodeBinaryTree<E>(e, node);
			node.setChildLeft(newNode);
			size += 2;
		}
	}
	
	public void insertRight(NodeBinaryTree<E> node, E e) {		
		if (node.right() == null) {
//			Create new node with parent node
			NodeBinaryTree<E> newNode = new NodeBinaryTree<E>(e, node);
			node.setChildRight(newNode);
			size += 2;
		}
	}
	
	public NodeBinaryTree<E> remove(NodeBinaryTree<E> removalNode) {
		
		if (removalNode.left() != null && removalNode.right() != null) {
//			Replace node with min value of node's right child e.g min(node.right())
			
			NodeBinaryTree<E> replacementNode = minRecursive(removalNode.right());
			NodeBinaryTree<E> replacementNodeParent = replacementNode.parent();
			NodeBinaryTree<E> replacementNodeRight = replacementNode.right();
//			Will be no left as it is the min value
						
			
			if (replacementNodeParent.left() == replacementNode) {
				replacementNodeParent.setChildLeft(replacementNodeRight);
			} else {
				replacementNodeParent.setChildRight(replacementNodeRight);
			}
			
			if (replacementNodeRight != null) {
				replacementNodeRight.setParent(replacementNodeParent);
			}
			
			NodeBinaryTree<E> removalNodeLeft = removalNode.left();
			NodeBinaryTree<E> removalNodeRight = removalNode.right();
			
			if (removalNode != root) {
				NodeBinaryTree<E> removalNodeParent = removalNode.parent();
				
				replacementNode.setParent(removalNodeParent);
				removalNodeParent.setChildRight(replacementNode);
				
			} else {
				replacementNode.setParent(null);
				root = replacementNode;
			}
			
			replacementNode.setChildLeft(removalNodeLeft);
			if (removalNodeLeft != null) {
				removalNodeLeft.setParent(replacementNode);
			}		
			
			if (replacementNodeParent != removalNode) {
//				Special Case
				replacementNode.setChildRight(removalNodeRight);
				if (removalNodeRight != null) {
					removalNodeRight.setParent(replacementNode);
				}
			}
			
			removalNode.setChildLeft(null);
			removalNode.setChildRight(null);
			removalNode.setParent(null);
			
			size-=2;
			return removalNode;
			
		} else if (removalNode.left() != null) {
//			Use left node to replace
			NodeBinaryTree<E> replacementNode = removalNode.left();
			NodeBinaryTree<E> parent = removalNode.parent();
			
			if (parent.left() == removalNode) {
				parent.setChildLeft(replacementNode);
			} else if (parent.right() == removalNode) {
				parent.setChildRight(replacementNode);
			}
			replacementNode.setParent(parent);
			removalNode.setChildLeft(null);
			removalNode.setParent(null);
//			n removed and it's right null node
			size-=2;
			
			if (removalNode == root) {
				root = replacementNode;
			}
			return removalNode;
			
		} else if (removalNode.right() != null) {
//			Use right node to replace
			NodeBinaryTree<E> replacementNode = removalNode.right();
			NodeBinaryTree<E> parent = removalNode.parent();
			
			if (parent.left() == removalNode) {
				parent.setChildLeft(replacementNode);
			} else if (parent.right() == removalNode) {
				parent.setChildRight(replacementNode);
			}
			replacementNode.setParent(parent);
			removalNode.setChildRight(null);
			removalNode.setParent(null);
//			n removed and it's left null node
			size-=2;
			
			if (removalNode == root) {
				root = replacementNode;
			}
			return removalNode;
			
		} else {
//			Both null
			NodeBinaryTree<E> parent = removalNode.parent();
			removalNode.setParent(null);
			
			if (parent.left() == removalNode) {
				parent.setChildLeft(null);
			} else if (parent.right() == removalNode) {
				parent.setChildRight(null);
			}
			size-=2;
			return removalNode;
		}
	}

		
	public void add(E e) {		
		if (isEmpty()) {
			addRoot(e);
		} else {
			addRecursive(root, e);
		}
	}

	private void addRecursive(NodeBinaryTree<E> current, E e) {
		int compareValue = e.compareTo(current.element());
		
		if(compareValue < 0) {
			if (current.left() != null) {
//				Recurse
				addRecursive(current.left(), e);
			} else {
//				Reached bottom of tree
				insertLeft(current, e);
			}
			
		} else if (compareValue > 0) {
			if (current.right() != null) {
				addRecursive(current.right(), e);
			} else {
//				Insert Right
				insertRight(current, e);
			}
			
		} else {
			throw new RuntimeException("Duplicate values not allowed");
		}
	}
	
	public NodeBinaryTree<E> search(E e) {
		return searchRecursive(root, e);
	}
	
	public NodeBinaryTree<E> searchRecursive(NodeBinaryTree<E> root, E e) {
		
//		Base Case - Value not found
		if (root == null) {
			return null;
		}
		int compareValue = e.compareTo(root.element());
		if (compareValue == 0) {
			return root;
		} else if (compareValue < 0) {
			return searchRecursive(root.left(), e);
		} else {
			return searchRecursive(root.right(), e);
		}
	}
	
	public NodeBinaryTree<E> min() {
		return minRecursive(root);
	}
	
	private NodeBinaryTree<E> minRecursive(NodeBinaryTree<E> root) {
		
		if (root.left() == null) {
			return root;
		} else {
			return minRecursive(root.left());
		}
	}
	
	public ArrayList<E> traverseInOrder() {
		return traverseInOrderRecursive(root);
	}
	
	private ArrayList<E> traverseInOrderRecursive(NodeBinaryTree<E> root) {
		ArrayList<E> list = new ArrayList<E>();
		
		if (root == null) {
			return list;
		}
		list.addAll(traverseInOrderRecursive(root.left()));
		list.add(root.element());
		list.addAll(traverseInOrderRecursive(root.right()));

		return list;
	}
	
	public ArrayList<E> traverseAlternative() {
		return traverseAlternativeRecursive(root);
	}
	
	private ArrayList<E> traverseAlternativeRecursive(NodeBinaryTree<E> root) {
		ArrayList<E> list = new ArrayList<E>();
		
		if (root == null) {
			return list;
		}
		
		list.addAll(traverseAlternativeRecursive(root.right()));
		list.add(root.element());
		list.addAll(traverseAlternativeRecursive(root.left()));
		
		return list;
	}
	
	public void printTree() {
//		Print horizontally
//		Traverse R,P,L
//		If no right child then print
		
		visitRPL(root, 0);
	}
	
	private void visitRPL(NodeBinaryTree<E> root, int depth) {
		String spaces = "";
		for (int i=0; i<depth; i++) {
			spaces += "   ";
		}
		
		if (root.right() == null) {
			spaces += "%s";
			System.out.printf(spaces, root.element());
			System.out.println();
			System.out.println();
		} else {
			visitRPL(root.right(), depth+1);
			spaces += "%s";
			System.out.printf(spaces, root.element());
			System.out.println();
			System.out.println();
		}
		
		if (root.left() != null) {
			visitRPL(root.left(), depth+1);
		}
		
	}
	
	public int getHeight() {
		if (isEmpty()) {
			return -1;
		}
		
		return recurHeight(root, 0, 0);
	}
	
	private int recurHeight(NodeBinaryTree<E> root, int currentMax, int currentHeight) {
		
		if (root == null) {
			if (currentHeight > currentMax) {
				return currentHeight;
			} else {
				return currentMax;
			}
		} else {
		
			currentHeight += 1;
			
			int left = recurHeight(root.left(), currentMax, currentHeight);
			currentMax = Math.max(currentMax, left);
			
			int right = recurHeight(root.right(), currentMax, currentHeight);
			currentMax = Math.max(currentMax, right);
			
			return currentMax;
		}
	}
	
//	IMPLEMENT AT SOME POINT
	
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
	
	
	
//	NOT NEEDED
	
	@Override
	public NodeBinaryTree<E> replace(E e, NodeBinaryTree<E> n) {
		
//		REDO OR REMOVE
//		Must be less than parent, greater than left and less than right
		
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
	
	public void attach() {
		;
	}
	
	 
}
