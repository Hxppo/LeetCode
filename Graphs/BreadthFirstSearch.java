package Graphs;

import java.util.LinkedList;

public class BreadthFirstSearch {
	private boolean[] isVisited;
	private int[] edgeTo;
	
	public BreadthFirstSearch(UndirectedGraph G, int s){
		isVisited = new boolean[G.v];
		edgeTo = new int[G.v];
		bfs(G, s);
	}
	
	private void bfs(UndirectedGraph G, int s) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		//将source vertex压入列队、标记已访问
		queue.addLast(s);
		isVisited[s] = true;
		while (!queue.isEmpty()) {
			int currentVertex = queue.getFirst();
			for (int w : G.adj(currentVertex)) {
				if (!isVisited[w]) {
					queue.addLast(w);
					edgeTo[w] = currentVertex;
					isVisited[w] = true;
				}
			}
		}
	}
}
