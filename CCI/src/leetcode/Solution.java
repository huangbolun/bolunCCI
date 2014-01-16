package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution {
    
    public static class node {
        public int index;
        public int depth;
        public HashSet<Integer> visited;
        public node(int _index, int _depth, HashSet<Integer> _pvisited) {
            index = _index;
            depth = _depth;
            visited = new HashSet<Integer>(_pvisited);
            visited.add(index); // add newly visited node
        }
    }
    
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // keeps a map mapping the neighboring relationship
        // between each string. 
        ArrayList<String> list = new ArrayList<String>(dict);
        list.add(0, start); // add the start string
        list.add(end); // add the end string
        LinkedList<node> queue = new LinkedList<node>(); // queue for bfs
        int depth = 0; // root depth from the start
        queue.add(new node(0, depth, new HashSet<Integer>())); // root
        boolean[][] neighborMap = new boolean[list.size()][list.size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                neighborMap[i][j] = isNeighbor(list.get(i), list.get(j));
            }
        }
        
        while (!queue.isEmpty()) {
            node root = queue.poll();
            if (root.index == list.size()-1) return root.depth;
            ArrayList<node> neighbors = findNeighbors(root, neighborMap);
            queue.addAll(neighbors);
        }
        return 0; // not found
    }
    
    public ArrayList<node> findNeighbors(node root, boolean[][] map) {
        ArrayList<node> neighbors = new ArrayList<node>();
        for (int i = 0; i < map[root.index].length; i++) {
            if (map[root.index][i] == true) {
                if (!root.visited.contains(i)) {
                    neighbors.add(new node(i, root.depth+1, root.visited));
                }
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