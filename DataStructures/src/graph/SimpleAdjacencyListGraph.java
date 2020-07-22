package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Hashmap and linked list implementation of a graph adjacency list
 * Key (Integer) : Linked List of adjacent vertices
 * @author stephen
 *
 */

public class SimpleAdjacencyListGraph {
	private HashMap<Integer, LinkedList<Integer>> adjacencyList;
	private int size;
	
	public int size() {
		return size;
	}
	
	public SimpleAdjacencyListGraph() {
		this.adjacencyList = new HashMap<Integer, LinkedList<Integer>>();
		this.size = 0;	
	}
	
	public void addVertex(int v) {
		if (! adjacencyList.containsKey(v)) {
			adjacencyList.put(v, new LinkedList<Integer>());
			size++;
		}
//		Throw key exists error
	}
	
	public List<Integer> getVertex(int v) {
		return adjacencyList.get(v);
	}
	
	public boolean addEdge(int v, int w) {
		if (! adjacencyList.containsKey(v) || ! adjacencyList.containsKey(w)) {
			return false;
		}
		adjacencyList.get(v).add(w);
		adjacencyList.get(w).add(v);
		return true;
	}
	
	/**
	 * Loop based implementation of BFS
	 * @param v
	 * @return
	 */
	public List<Integer> BFS(int v) {
		HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>(size());
		List<Integer> bfs = new ArrayList<Integer>();
		
		int counter = 0;
		bfs.add(v);
		visited.put(v, true);
		
		while (counter < size() - 1) {
			v = bfs.get(counter);
			visited.put(v, true);
			for (int a : getVertex(v)) {
				if (! visited.getOrDefault(a, false)) {
					bfs.add(a);
					visited.put(a, true);
				}
			}
			counter++;
		}

		return bfs;
	}
	/**
	 * Queue based implementation of BFS
	 * @param v
	 * @return
	 */
	public List<Integer> BFSQueue(int v) {
		HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>(size());
		LinkedList<Integer> queue = new LinkedList<Integer>();
		List<Integer> bfs = new ArrayList<Integer>();
		
		queue.add(v);
		
		while (queue.size() != 0) {
			int node = queue.poll();
			
			if (! visited.getOrDefault(node, false)) {
				visited.put(node, true);
				bfs.add(node);
				Iterator<Integer> i = getVertex(node).listIterator();
				while (i.hasNext()) {
					int a = i.next();
					if (! visited.getOrDefault(a, false)) {
						queue.add(a);
					}
				}
			}
		}
		
		return bfs;
	}
	
	public List<Integer> DFS(int v) {
		List<Integer> dfs = new ArrayList<Integer>();
		
		return dfs;
	}
	
	public static void main(String[] args) {
		SimpleAdjacencyListGraph g = new SimpleAdjacencyListGraph();
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addVertex(6);
		
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(2, 5);
		g.addEdge(3, 5);
		g.addEdge(3, 4);
		g.addEdge(3, 6);
		g.addEdge(4, 6);		
		
		System.out.println(g.BFSQueue(1));
	}
}
