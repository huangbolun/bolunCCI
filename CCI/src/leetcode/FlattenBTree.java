package leetcode;

import java.util.ArrayList;

import leetcode.IsValidBST.TreeNode;

public class FlattenBTree {
	public void flatten(TreeNode root) {
        if (root == null) return;
        ArrayList<TreeNode> preorder = new ArrayList<TreeNode>();
        preorder(preorder, root);
        for (int i = 0; i < preorder.size()-1; i++) {
            TreeNode tmp1 = preorder.get(i);
            TreeNode tmp2 = preorder.get(i+1);
            tmp1.left = null;
            tmp1.right = tmp2;
        }
        return;
    }
    
    public void preorder(ArrayList<TreeNode> preorder, TreeNode root) {
        if (root == null) return;
        preorder.add(root);
        preorder(preorder, root.left);
        preorder(preorder, root.right);
        return;
    }
}