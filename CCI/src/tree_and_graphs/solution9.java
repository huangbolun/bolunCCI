package tree_and_graphs;

/**
 * solution to CCI 4.9
 * print all paths which sum to a given value
 * ** negative path value is allowed so we cannot stop when we find sum = sum
 * ** we look up to see whether this node form a sum up to root
 * @author Bolun
 *
 */
public class solution9 {
	
	public void printPaths(TreeNode root, int sum, int[] path, int level) {
		if (root == null)
			return;
		
		/*insert current node into the path*/
		path[level] = root.value;
		
		/* look for paths with a sum that ends at this node */
		int t = 0;
		for (int i = level; i >= 0; i--)
		{
			t += path[i];
			if (t == sum)
				print(path, i, level);
		}
		
		printPaths(root.leftChild, sum, path, level + 1);
		printPaths(root.rightChild, sum, path, level + 1);
		
		path[level] = Integer.MIN_VALUE;
		
	}
	
	/* main function: find the paths starting from level 0 */
	public void findSum(TreeNode root, int sum) {
		int[] path = new int[depth(root)];
		printPaths(root, sum, path, 0);
	}
	
	public int depth(TreeNode node) {
		if (node == null)
			return 0;
		return Math.max(depth(node.leftChild), depth(node.rightChild)) + 1;
	}
	
	public static void print(int[] path, int start, int end) {
		for (int j = start; j <= end; j++) {
			if (j == end)
				System.out.print(path[j]);
			System.out.print(path[j]+"->");
		}
	}
	
}