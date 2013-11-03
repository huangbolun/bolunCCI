package tree_and_graphs;

public class TreeNode {
	
	int value;
	TreeNode leftChild;
	TreeNode rightChild;
	
	public TreeNode(int val) {
		this.value = val;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public TreeNode insert(TreeNode newNode) {
		if (newNode.value < this.value)
			return this.leftChild.insert(newNode);
		else
			return this.rightChild.insert(newNode);
	}
}