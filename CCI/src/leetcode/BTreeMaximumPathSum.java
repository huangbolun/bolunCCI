package leetcode;

import leetcode.IsValidBST.TreeNode;

/*
0) record the cur_max in every node op
1) if the node is leaf, return the value
2) if node == null, return 0 ***
3) if it is not leaf, then get left_sub_tree() & right_sub_tree()
4) if cur_val > 0:
	4.1) left_sub_tree() > 0 && right_sub_tree() > 0, record cur_val+left_sub_tree()+right_sub_tree(), return cur_val+Math.max(left, right)
	4.2) left_sub_tree() < 0 && right_sub_tree() > 0, return cur_val+right_sub_tree()
	4.3) left_sub_tree() > 0 && right_sub_tree() < 0, return cur_val+left_sub_tree()
	4.4) left_sub_tree() < 0 && right_sub_tree() < 0, return cur_val
5) if cur_val < 0:
	5.1) left_sub_tree() > 0 && right_sub_tree() > 0, record cur_val+left_sub_tree()+right_sub_tree(), return cur_val+Math.max(left, right)
	5.2) left_sub_tree() < 0 && right_sub_tree() > 0, return cur_val+right_sub_tree()
	5.3) left_sub_tree() > 0 && right_sub_tree() < 0, return cur_val+left_sub_tree()
	5.4) left_sub_tree() < 0 && right_sub_tree() < 0, return cur_val
*/
public class BTreeMaximumPathSum {
    
	public int max;
    
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE; // initialize as the **min**
        maxPath(root); // recursively find max path sum
        return max;
    }
    
    public int maxPath(TreeNode root) {
        if (root == null) return 0; // null
        if (root.left == null && root.right == null) {
            if (root.val > max) max = root.val;
            return root.val;
        } // leaf
        int right = 0;
        int left = 0;
        if (root.val >= 0) {
            if (root.left == null && root.right != null) {
                right = maxPath(root.right);
                if (right >= 0) {
                    if (root.val+right > max) max = root.val+right;
                    return root.val+right;
                } else {
                    if (root.val > max) max = root.val;
                    return root.val;
                }
            } else if (root.left != null && root.right == null) {
                left = maxPath(root.left);
                if (left >= 0) {
                    if (root.val+left > max) max = root.val+left;
                    return root.val+left;
                } else {
                    if (root.val > max) max = root.val;
                    return root.val;
                }
            } else {
                left = maxPath(root.left);
                right = maxPath(root.right);
                if (left >= 0 && right >= 0) {
                    if (root.val+left+right > max) max = root.val+left+right;
                    return root.val+Math.max(left, right);
                } else if (left < 0 && right >= 0) {
                    if (root.val+right > max) max = root.val+right;
                    return root.val+right;
                } else if (left >= 0 && right < 0) {
                    if (root.val+left > max) max = root.val+left;
                    return root.val+left;
                } else {
                    if (root.val > max) max = root.val;
                    return root.val;
                }
            }
        } else { // root.val < 0
            if (root.left == null && root.right != null) {
                right = maxPath(root.right);
                if (right >= 0) {
                    if (right > max) max = right;
                    return root.val+right;
                } else {
                    if (root.val > max) max = root.val;
                    return root.val;
                }
            } else if (root.left != null && root.right == null) {
                left = maxPath(root.left);
                if (left >= 0) {
                    if (left > max) max = left;
                    return root.val+left;
                } else {
                    if (root.val > max) max = root.val;
                    return root.val;
                }
            } else {
                left = maxPath(root.left);
                right = maxPath(root.right);
                if (left >= 0 && right >= 0) {
                    if (root.val+left+right > max) max = root.val+left+right;
                    return root.val+Math.max(left, right);
                } else if (left < 0 && right >= 0) {
                    if (right > max) max = right;
                    return root.val+right;
                } else if (left >= 0 && right < 0) {
                    if (left > max) max = left;
                    return root.val+left;
                } else {
                    if (root.val > max) max = root.val;
                    return root.val;
                }
            }
        }
    }
}