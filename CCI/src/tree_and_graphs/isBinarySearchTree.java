package tree_and_graphs;
/**
 * solution to 4.5
 * check is a binary tree is binary search tree
 * @author Bolun
 *
 */
public class isBinarySearchTree {
	
	
	/**
	 * this is not very intuitive
	 * @param root
	 * @param subcheck should be true at the very beginning
	 * @return
	 */
	public boolean check(TreeNode root) {
		
		if (root == null)
			return true;
		
		boolean left = false;
		boolean right = false;
		
		if (root.leftChild == null && root.rightChild == null)
		{
			left = true;
			right = true;
		}
		if (root.leftChild == null && root.rightChild != null)
			left = true;
		if (root.rightChild == null && root.leftChild != null)
			right = true;
		if (root.leftChild != null && root.leftChild.value <= root.value)
			left = check(root.leftChild);
		if (root.rightChild != null && root.rightChild.value > root.value)
			right = check(root.rightChild);
		
		if (left && right)
			return true;
		else
			return false;
	}
	
}