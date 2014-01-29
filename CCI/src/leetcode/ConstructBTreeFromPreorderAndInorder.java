package leetcode;

import leetcode.IsValidBST.TreeNode;

public class ConstructBTreeFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode root = buildTree_recursive(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return root;
    }
    
    public TreeNode buildTree_recursive(int[] preorder, int pbegin, int pend, int[] inorder, int ibegin, int iend) {
        if (pbegin == pend) { // only one node left
            return new TreeNode(preorder[pbegin]);
        }
        TreeNode root = new TreeNode(preorder[pbegin]); // the root
        int index = findRootIndexinInorder(inorder, preorder[pbegin], ibegin, iend);
        // index-ibegin
        if (index <= ibegin) { // no left child
            root.left = null;
        } else {
            root.left = buildTree_recursive(preorder, pbegin+1, pbegin+(index-ibegin), inorder, ibegin, index-1);
        }
        if (index >= iend) { // no right child
            root.right = null;
        } else {
            root.right = buildTree_recursive(preorder, pbegin+1+index-ibegin, pend, inorder, index+1, iend);
        }
        return root;
    }
    
    public int findRootIndexinInorder(int[] inorder, int target, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            if (inorder[i] == target) return i;
        }
        return begin; // default
    }
}