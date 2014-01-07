package leetcode;

import java.util.ArrayList;
import java.util.Stack;
import leetcode.IsValidBST.TreeNode;

public class TreeInOrderIterative {
	public class Solution {
	    public ArrayList<Integer> inorderTraversal(TreeNode root) {
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        if (root == null) return list;
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        TreeNode cur = root; // pointer
	        //stack.push(root);
	        boolean done = false;
	        while (!done) {
	            if (cur != null) { // if current is not null 
	                stack.add(cur);
	                cur = cur.left; // keep looking for left child
	            } else { // if it is null, the stack.top() is the left bottom most node to be added
	                if (!stack.isEmpty()) {
	                    TreeNode top = stack.pop(); // always retrieve the top node of stack
	                    list.add(top.val);
	                    cur = top.right; // move the pointer to the top.right
	                } else {
	                    done = true; // when the stack is empty, it is done!
	                }
	            }
	        }
	        return list;
	    }
	}
}