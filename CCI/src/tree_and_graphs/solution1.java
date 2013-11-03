package tree_and_graphs;

/**
 * check if the tree is balanced or not
 * method 1: a function that get the height of tree; check whether the diff.height of left and right is greater than 1
 * method 2: get the height of subtree meanwhile examine the diff.height of left and right
 * @author Bolun
 *
 */
public class solution1 {
	
	public static int checkHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		return Math.max(checkHeight(root.leftChild), checkHeight(root.rightChild))+1;
	}
	
	public static boolean isBoolean(TreeNode root) {
		if (root == null) {
			return true;
		}
		int diff = Math.abs(checkHeight(root.leftChild) - checkHeight(root.rightChild));
		if (diff > 1) {
			return false;
		} else {
			return (isBoolean(root.leftChild) && isBoolean(root.rightChild)); // this is not efficient because it has lots
																			  // of redundant computation
		}
	}
	/* check the diff of height while getting the height; return -1 if it is unbalanced */
	public static int check(TreeNode root) {
		if (root == null) return 0;
		int leftHeight = check(root.leftChild);
		int rightHeight = check(root.rightChild);
		if (leftHeight == -1)
			return -1;
		if (rightHeight == -1)
			return -1;
		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		else
			return Math.max(leftHeight, rightHeight)+1;
	}
	
	public static boolean isBalanced(TreeNode root) {
		if (check(root) == -1)
			return true;
		else 
			return false;
	}
	
}