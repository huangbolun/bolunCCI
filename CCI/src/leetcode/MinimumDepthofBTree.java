package leetcode;

import leetcode.IsValidBST.TreeNode;

public class MinimumDepthofBTree {
    
    public int min_depth;
    
    public int minDepth(TreeNode root) {
        min_depth = Integer.MAX_VALUE;
        if (root == null) return 0;
        find_minDepth(root, 1);
        return min_depth;
    }
    
    public void find_minDepth(TreeNode root, int depth) {
        if (root == null) return;
        if (root.left == null && root.right != null) {
            find_minDepth(root.right, depth+1);
        } else if (root.left != null && root.right == null) {
            find_minDepth(root.left, depth+1);
        } else if (root.left != null && root.right != null) {
            find_minDepth(root.left, depth+1);
            find_minDepth(root.right, depth+1);
        } else if (root.left == null && root.right == null) { // a leaf
            if (depth < min_depth) min_depth = depth;
        } else {
            return;
        }
        return;
    }
    
}