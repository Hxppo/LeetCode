package Graphs;

import java.util.*;

public class UndirectedGraph {
	int v;
	private ArrayList<LinkedList<Integer>> adj;
	
	public UndirectedGraph() {
		this.v = 0;
		this.adj = new ArrayList<LinkedList<Integer>>();
	}
	
	public UndirectedGraph(int v) {
		this.v = v;
		this.adj = new ArrayList<LinkedList<Integer>>(v);
	}
	
	public void addEdge(int v, int w) {
		adj.get(v).add(w);
		adj.get(w).add(v);
	}
	
	public Iterable<Integer> adj(int v) {
		return adj.get(v);
	}
	
	public void deleteEdge(int v, int w) {
		adj.get(v).remove(w);
		adj.get(w).remove(v);
	}
}
