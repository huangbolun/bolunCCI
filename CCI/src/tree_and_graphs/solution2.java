package tree_and_graphs;

import java.util.LinkedList;

/**
 * solution to CCI 4.2
 * find out whether there is route between two nodes
 * @author Bolun
 *
 */
public class solution2 {
	
	public static boolean hasRoute(Graph<Integer> graph, GraphNode<Integer> src, GraphNode<Integer> dst) {
		
		LinkedList<GraphNode<Integer>> queue = new LinkedList<GraphNode<Integer>>();
		
		/* set all nodes unvisited */
		for (GraphNode<Integer> n : graph.getNodes())
		{
			n.state = State.unvisited;
		}
		
		queue.add(src);
		GraphNode<Integer> root;
		while (!queue.isEmpty()) {
			root = queue.poll();
			if (root != null) {
				if (root.state == State.unvisited) {
					for (GraphNode<Integer> a : root.getAdjacent())
					{
						if (a == dst) {
							return true;
						}
						queue.offer(a);
					}
				}
				root.state = State.visited;
			}
		}
		return false;
	}
	
	
}