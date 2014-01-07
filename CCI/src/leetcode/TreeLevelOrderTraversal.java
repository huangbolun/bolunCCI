package leetcode;

import java.util.ArrayList;

import leetcode.IsValidBST.TreeNode;

public class TreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> levelList = new ArrayList<ArrayList<Integer>>();
        levelOrder_recursive(root, levelList, 0);
        // upside-down
        for (int i = 0; i < levelList.size()/2; i++) {
            ArrayList<Integer> tmp = levelList.get(i);
            levelList.set(i, levelList.get(levelList.size()-i-1));
            levelList.set(levelList.size()-i-1, tmp);
        }
        return levelList;
    }
    // pre-order traversal
    public void levelOrder_recursive(TreeNode root, ArrayList<ArrayList<Integer>> result, int depth) {
        if (root == null) return;
        if (depth == 0) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            result.add(list);
        }
        else if (depth < result.size()) {
            ArrayList<Integer> list = result.get(depth);
            list.add(root.val);
        } else {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            result.add(list);
        }
        levelOrder_recursive(root.left, result, depth+1);
        levelOrder_recursive(root.right, result, depth+1);
        return;
    }
}