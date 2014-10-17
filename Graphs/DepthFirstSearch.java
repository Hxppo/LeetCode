package Graphs;

public class DepthFirstSearch {
	private boolean[] isVisited; // check whether vertex has been visited
	private int[] edgeTo; // previous vertex on path from s to v
	public int s; // source vertex
	
	public DepthFirstSearch(UndirectedGraph G, int s) {
		isVisited = new boolean[G.v];
		edgeTo = new int[G.v];
		dfs(G, s);
	}
	
	/**
	 * 深度优先搜索，采用先序遍历的方式完成
	 * 注意相比二叉树的先序遍历，需要检查根节点是否被访问
	 * 时间复杂度：O(E+V)
	 * @param G
	 * @param s
	 */
	public void dfs(UndirectedGraph G, int s) {
		isVisited[s] = true;
		for (int w: G.adj(s)) {
			if (!isVisited[w]){
				isVisited[w] = true; // 检查当前结点是否已经被访问
				edgeTo[w] = s;
				dfs(G, w);
			}	
		}
	}
}
