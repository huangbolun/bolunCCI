package leetcode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Definition for undirected graph.
 * @author Bolun
 *
 */
 
public class CloneGraph {
	
	class UndirectedGraphNode {
	    int label;
	    ArrayList<UndirectedGraphNode> neighbors;
	    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	}
	
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Hashtable<UndirectedGraphNode,UndirectedGraphNode> ht = new Hashtable<UndirectedGraphNode,UndirectedGraphNode>(); // table to store nodes already created
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>(); // queue to store nodes to be processed
        UndirectedGraphNode nodeClone = new UndirectedGraphNode(node.label);
        ht.put(node, nodeClone);
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.remove(); // cur node
            UndirectedGraphNode curClone = ht.get(curNode); // clone node
            ArrayList<UndirectedGraphNode> neighbors = curNode.neighbors;
            for (int i = 0; i < neighbors.size(); i++) {
                UndirectedGraphNode neighbor = neighbors.get(i);
                if (!ht.containsKey(neighbor)) {
                    UndirectedGraphNode neighborClone = new UndirectedGraphNode(neighbor.label);
                    ht.put(neighbor, neighborClone);
                    queue.add(neighbor);
                    curClone.neighbors.add(neighborClone);
                } else { // already copied!
                    UndirectedGraphNode neighborClone = ht.get(neighbor);
                    curClone.neighbors.add(neighborClone);
                }
            }
        }
        return nodeClone;
    }
}