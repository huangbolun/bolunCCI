package tree_and_graphs;

import java.util.ArrayList;

public class Graph<V> {
	
	ArrayList<GraphNode<V>> Node;
	
	public Graph() {
		Node = new ArrayList<GraphNode<V>>();
	}
	
	public ArrayList<GraphNode<V>>getNodes() {
		return Node;
	}
	
}