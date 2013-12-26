package leetcode;

import java.util.ArrayList;
import tree_and_graphs.TreeNode;
import java.util.Stack;

public class TreeTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // post-order interatively with the help of stack
        // 1. traversal the left subtree
        // 2. traversal the right subtree
        // 3. visit the root
        Stack<Integer> tree = new Stack<Integer>();
        ArrayList<Integer> preorder = new ArrayList<Integer>();
        
        TreeNode current = root;
        
        while (!tree.isEmpty()) {
        	
        }
        
        return preorder;
    }
    
    public ArrayList<Integer> postorderTraversal_recursive(TreeNode root) {
        // post-order
        // 1. traversal the left subtree
        // 2. traversal the right subtree
        // 3. visit the root
        ArrayList<Integer> preorder = new ArrayList<Integer>();
        
        preorderTraversal_core(preorder, root);
        
        return preorder;
    }
    
    public void preorderTraversal_core(ArrayList<Integer> result, TreeNode root) {
        if (root == null)
            return;
        else {
            if (root.leftChild != null)
                preorderTraversal_core(result, root.leftChild);
            if (root.rightChild != null)
                preorderTraversal_core(result, root.rightChild);
            result.add(root.value);
        }
    }
}