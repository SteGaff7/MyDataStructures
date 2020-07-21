package all_my_data_structures;

import java.util.Iterator;

public interface Tree<T> {
	public int size();
	public boolean isEmpty();
	public NodeBinaryTree<T> root();
	
	public NodeBinaryTree<T> parent(NodeBinaryTree<T> n);
	public boolean isInternal(NodeBinaryTree<T> n);
	public boolean isExternal(NodeBinaryTree<T> n);
	public boolean isRoot(NodeBinaryTree<T> n);
	public NodeBinaryTree<T> replace(T e, NodeBinaryTree<T> n);
	
	public Iterator<T> iterator();
	public Iterator<T> positions();
	public Iterator<T> children(NodeBinaryTree<T> p);	
}
