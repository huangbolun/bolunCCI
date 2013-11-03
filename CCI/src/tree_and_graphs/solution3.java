package tree_and_graphs;

/**
 * given a ascending sorted array, convert it into binary search tree with min depth
 * @author Bolun
 *
 */
public class solution3 {

	public TreeNode createMinimalBST (int[] array, int start, int end) {
		
		if (start > end) return null;

		int mid = (end - start) / 2;
		TreeNode root = new TreeNode(array[mid]);
		
		root.leftChild.insert(createMinimalBST(array, start, mid - 1));
		root.rightChild.insert(createMinimalBST(array, mid, end));
		return root;
	}
	
	public TreeNode createMinimalBST(int[] array) {
		
		TreeNode root = createMinimalBST(array, 0, array.length - 1);
		return root;
	}
	
}