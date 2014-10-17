package Others;

import java.util.*;

public class UndirectedGraphNode {
	public int label;
	public List<UndirectedGraphNode> neighbors;
	
	public UndirectedGraphNode(int x) {
		this.label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
