package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadder {
    
    public static class node {
        public String val;
        public int depth;
        public HashSet<String> visited;
        public node(String _val, int _depth, HashSet<String> _pvisited) {
            val = _val;
            depth = _depth;
            visited = new HashSet<String>(_pvisited);
            visited.add(_val); // add newly visited node
        }
    }
    // precomputing the neighbor map is not necessary good because a lot of node will be used at all
    // the thought is correct pay attention to visited
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // keeps a map mapping the neighboring relationship
        // between each string. 
        ArrayList<String> list = new ArrayList<String>(dict);
        list.add(0, start); // add the start string
        list.add(end); // add the end string
        LinkedList<node> queue = new LinkedList<node>(); // queue for bfs
        int depth = 0; // root depth from the start
        queue.add(new node(start, depth, new HashSet<String>())); // root
        /*
        boolean[][] neighborMap = new boolean[list.size()][list.size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                neighborMap[i][j] = isNeighbor(list.get(i), list.get(j));
            }
        }*/
        
        while (!queue.isEmpty()) {
            node root = queue.poll(); // remove and retrieve head
            if (root.val.equals(end)) return root.depth;
            ArrayList<node> neighbors = findNeighbors(root, dict);
            queue.addAll(neighbors);
        }
        return 0; // not found
    }
    
    
    public ArrayList<node> findNeighbors(node root, HashSet<String> dict) {
        ArrayList<node> neighbors = new ArrayList<node>();
        for (String e : dict) {
            if (isNeighbor(e, root.val)) {
            	neighbors.add(new node(e, root.depth+1, root.visited));
            }
        }
        return neighbors;
    }
    
    public boolean isNeighbor(String s1, String s2) {
        // is neighbor iff one letter diff
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count += 1;
                if (count > 2) {
                    return false;
                }
            }
        }
        if (count == 1) return true;
        return false;
    }
}