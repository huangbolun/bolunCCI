package tree_and_graphs;

/**
 * find the 'next node' of a given node in a binary tree
 * each node has a link to its parent
 * @author Bolun
 *
 */
public class solution6 {
	
	public TreeNode findNextNode(TreeNode root, TreeNode node) {
		
		TreeNode myNode = searchBST(root, node);
		if (myNode.rightChild != null)
			return myNode.rightChild;
		else
			return findLeftMostChild(root.rightChild);
		
	}
	
	public TreeNode searchBST(TreeNode root, TreeNode node) {
		if (root == null) return null;
		else {
			if (root == node)
				return root;
			if (node.value <= root.value)
				return searchBST(root.leftChild, node);
			else
				return searchBST(root.rightChild, node);
		}
	}
	
	public TreeNode findLeftMostChild(TreeNode node) {
		if (node.leftChild == null)
			return node;
		else
			return findLeftMostChild(node.leftChild);
	}
}