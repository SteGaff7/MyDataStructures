package all_my_data_structures;

public interface NodeTree<N, O> {	
	public N parent();
	public void setParent(N p);
	public O element();
	public void setElement(O e);	
}
