package leetcode;

import java.util.ArrayList;

import leetcode.IsValidBST.TreeNode;

/**
 * ***DFS***
 * @author Bolun
 *
 */
public class UniqueBinarySearchTreeII {
    public ArrayList<TreeNode> generateTrees(int n) {
        return buildTree(1, n);
    }
    
    public ArrayList<TreeNode> buildTree(int begin, int end) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>(); // result list of trees
        if (begin > end) {
            res.add(null); // null if there is nothing left in this half
            return res;
        }
        
        for (int i = begin; i <= end; i++) {
            ArrayList<TreeNode> left = buildTree(begin, i-1);
            ArrayList<TreeNode> right = buildTree(i+1, end);
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    TreeNode root = new TreeNode(i); // root node for this tree
                    root.left = left.get(j);
                    root.right = right.get(k);
                    res.add(root); // add to result set
                }
            }
        }
        return res;
    }
}