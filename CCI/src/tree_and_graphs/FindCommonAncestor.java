package tree_and_graphs;

/**
 * find the first common ancestor of two node in a binary tree (not necessary BST)
 * if the tree is BST, we can modify the find to see where does the route diverge
 * @author Bolun
 *
 */
public class FindCommonAncestor {

	/**
	 * 1) return p, if root's subtree includes only p
	 * 2) return q, if root's subtree includes only q
	 * 3) retur null, if neither p nor q are in root's subtree
	 * 4) return common ancestor of p and q
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		if (root == null)
			return null;
		if (root == p || root == q)
			return root;
		
		TreeNode left = commonAncestor(root.leftChild, p, q);
		if (left != null && left != p && left != q) // common ancestor found here
			return left;
		
		TreeNode right = commonAncestor(root.rightChild, p, q);
		if (right != null && right != p && right != q) // common ancestor found here
			return right;
		
		if (right != null && left != null) // p and q found in diff subtree
			return root;
		else if (right == null) // either left or right is non-null
			return left;
		else
			return right;
	}
	
	/**
	 * not quite efficient since it traversal the lower tree time after time
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode findCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		if (root == null)
			return null;
		
		if (root == p && (isInSubTree(root.leftChild, q) || isInSubTree(root.rightChild, q)))
			return root;
		if (root == q && (isInSubTree(root.leftChild, p) || isInSubTree(root.rightChild, p)))
			return root;
		if (isInSubTree(root.leftChild, p) && isInSubTree(root.leftChild, q))
			return findCommonAncestor(root.leftChild, p, q);
		if (isInSubTree(root.rightChild, p) && isInSubTree(root.rightChild, q))
			return findCommonAncestor(root.rightChild, p, q);
		return root;
	}
	
	public boolean isInSubTree(TreeNode root, TreeNode n) {
		if (root == null)
			return false;
		if (root == n) {
			return true;
		}
		return (isInSubTree(root.leftChild, n) || isInSubTree(root.rightChild, n));
	}
	
	public TreeNode getCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || isInSubTree(root, p) || isInSubTree(root, q))
			return null; // error checking: whether p, q really exist in the tree
		else
			return findCommonAncestor(root, p, q);
	}
	
}