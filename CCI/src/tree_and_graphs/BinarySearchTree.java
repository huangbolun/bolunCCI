package tree_and_graphs;

public class BinarySearchTree {
	
	TreeNode root;
	
	public BinarySearchTree(int val) {
		this.root = new TreeNode(val);
	}
	
	public TreeNode insert(TreeNode root, TreeNode newNode) {
		if (root == null)
			root = newNode;
		else {
			if (newNode.value < root.value)
				root.leftChild = insert(root.leftChild, newNode);
			else
				root.rightChild = insert(root.rightChild, newNode);
		}
		return root;
	}
	
	public void insertBST(int val) {
		TreeNode newNode = new TreeNode(val);
		this.root = insert(this.root, newNode);
	}
	
	public TreeNode search(TreeNode root, int val) {
		if (root == null)
			return null;
		else {
			if (val == root.value) // use newNode.AnyObject.compareTo(root.AnyObject) if is an object
				return root;
			else if (val < root.value)
				return search(root.leftChild, val);
			else
				return search(root.rightChild, val);
		}
	}
	
	public TreeNode searchBST(int val) {
		TreeNode result = search(this.root, val);
		if (result == null)
			return null;
		else
			return result;
	}
}