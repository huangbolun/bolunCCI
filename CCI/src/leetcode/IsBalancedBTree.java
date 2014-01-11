package leetcode;

import leetcode.IsValidBST.TreeNode;

public class IsBalancedBTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int l = get_height(root.left);
        int r = get_height(root.right);
        if (l == -1 || r == -1) return false;
        if (Math.abs(l-r) > 1) return false;
        return true;
    }
    
    public int get_height(TreeNode root) {
        if (root == null) return 0;
        int lh = get_height(root.left);
        int rh = get_height(root.right);
        if (lh == -1 || rh == -1) return -1;
        if (Math.abs(lh-rh) > 1) return -1;
        return Math.max(lh+1, rh+1);
    }
}