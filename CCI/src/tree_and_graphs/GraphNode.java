package tree_and_graphs;

import java.util.ArrayList;

public class GraphNode<V> {
	
	ArrayList<GraphNode<V>> adjacent;
	State state;
	V val;
	
	public GraphNode(V _val) {
		val = _val;
		state = State.unvisited;
		adjacent = new ArrayList<GraphNode<V>>();
	}
	
	public boolean addAdjacentNode(GraphNode<V> outNode) {
		return this.adjacent.add(outNode);
	}
	
	public ArrayList<GraphNode<V>> getAdjacent() {
		return adjacent;
	}
	
}