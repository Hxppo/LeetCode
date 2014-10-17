/**
 * Clone Graph
 * 
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */

import java.util.*;

import Others.UndirectedGraphNode;

public class Solution102 {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) return node;
		
		// Define a queue for BFS
		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.add(node);
		
		// define the node for result
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		UndirectedGraphNode res = new UndirectedGraphNode(node.label);
		map.put(node, res);
		
		// loop for breadth first search
		while (!queue.isEmpty()) {
			UndirectedGraphNode currentNode = queue.removeFirst();
			UndirectedGraphNode corsNode = map.get(currentNode);
			
			for (UndirectedGraphNode nb : currentNode.neighbors) {
				if (map.containsKey(nb)) {
					// this node has been copied. add this node into arrayList
					corsNode.neighbors.add(map.get(nb));
				} else {
					// this node has not been copied yet
					// create this node and enqueue its corresponding originate node
					UndirectedGraphNode copyNode = new UndirectedGraphNode(nb.label);
					// add it to current node's neighbor
					corsNode.neighbors.add(copyNode);
					// put this pair into map
					map.put(nb, copyNode);
					// add copy node into queue
					queue.add(nb);
				}
			}
		}
		
		return res;
	}
	
}
