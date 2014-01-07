package leetcode;

import leetcode.IsValidBST.TreeNode;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
        //Arrays.sort(num);
        TreeNode root = toBST(num, 0, num.length-1);
        return root;
    }
    
    public TreeNode toBST(int[] num, int begin, int end) {
        if (begin > end) return null;
        if (begin == end) {
            return new TreeNode(num[begin]);
        }
        int mid = (begin + end) / 2;
        TreeNode newNode = new TreeNode(num[mid]);
        newNode.left = toBST(num, begin, mid-1);
        newNode.right = toBST(num, mid+1, end);
        return newNode;
    }
}