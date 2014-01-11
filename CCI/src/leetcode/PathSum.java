package leetcode;

import leetcode.IsValidBST.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return hasPathSumDFS(root, 0, sum);
    }
    
    public boolean hasPathSumDFS(TreeNode root, int cur, int target) {
        /* root-to-leaf path */
        if (root == null) {
            // do nothing
        } else if (root.left == null && root.right == null) {
            int depth = cur+root.val;
            if (depth == target) { // find the path
                return true;
            }
        } else if (root.left == null && root.right != null) {
            boolean b = hasPathSumDFS(root.right, cur+root.val, target);
            if (b == true) return true;
        } else if (root.left != null && root.right == null) {
            boolean b = hasPathSumDFS(root.left, cur+root.val, target);
            if (b == true) return true;
        } else { // left and right r non-null
            boolean b = hasPathSumDFS(root.right, cur+root.val, target);
            if (b == true) return true;
            b = hasPathSumDFS(root.left, cur+root.val, target);
            if (b == true) return true;
        }
        return false;
    }
}