package leetcode;

import leetcode.IsValidBST.TreeNode;

public class BuildTreePostorderInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        return buildTree_recursive(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    public TreeNode buildTree_recursive(int[] inorder, int ibegin, int iend, int[] postorder, int pbegin, int pend) {
        if (pbegin >= pend) {
            return new TreeNode(postorder[pbegin]);
        }
        TreeNode root = new TreeNode(postorder[pend]);
        int index = findRootIndexInorder(inorder, ibegin, iend, postorder[pend]);
        if (index == ibegin) {
            root.left = null;
        } else { // index-ibegin
            root.left = buildTree_recursive(inorder, ibegin, index-1, postorder, pbegin, pbegin+index-ibegin-1);
        }
        if (index == iend) {
            root.right = null;
        } else {
            root.right = buildTree_recursive(inorder, index+1, iend, postorder, pbegin+index-ibegin, pend-1);
        }
        return root;
    }
    
    public int findRootIndexInorder(int[] inorder, int begin, int end, int target) {
        for (int i = begin; i <= end; i++) {
            if (target == inorder[i]) {
                return i;
            }
        }
        return begin; // default
    }
}