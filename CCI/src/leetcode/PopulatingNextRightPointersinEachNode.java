package leetcode;

import java.util.ArrayList;

public class PopulatingNextRightPointersinEachNode {
    
	public static class TreeLinkNode {
	    int val;
	    TreeLinkNode left, right, next;
	    TreeLinkNode(int x) { val = x; }
	}
	
	public void connect(TreeLinkNode root) {
        if (root == null) return;
        ArrayList<TreeLinkNode> connect = new ArrayList<TreeLinkNode>();
        connect.add(root);
        bfs(connect);
        return;
    }
    
    public void bfs(ArrayList<TreeLinkNode> connect) {
        if (connect == null || connect.size() == 0) return;
        ArrayList<TreeLinkNode> next_connect = new ArrayList<TreeLinkNode>();
        for (int i = 0; i < connect.size()-1; i++) {
            connect.get(i).next = connect.get(i+1);
        }
        for (int i = 0; i < connect.size(); i++) {
            if (connect.get(i).left != null) {
                next_connect.add(connect.get(i).left);
            }
            if (connect.get(i).right != null) {
                next_connect.add(connect.get(i).right);
            }
        }
        bfs(next_connect);
        return;
    }
}