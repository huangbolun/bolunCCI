package leetcode;

import leetcode.IsValidBST.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val)
        {
            return false;
        }
        if ((p.left == null && q.left != null) || (p.left != null && q.left == null) || (p.right == null && q.right != null) || (p.right != null && q.right == null)) // left and right is not equal
        {
            return false;
        } else if (p.left == null && q.left == null && p.right != null && q.right != null) { // left = null and right != null
            return isSameTree(p.right, q.right);
        } else if (p.left != null && q.left != null && p.right == null && q.right == null) { // left != null and right = null
            return isSameTree(p.left, q.left);
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}