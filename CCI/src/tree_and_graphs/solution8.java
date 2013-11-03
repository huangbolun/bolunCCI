package tree_and_graphs;

/**
 * solution to CCI 4.8
 * determine whether T2(smaller tree) is a subtree of T1(larger tree)
 * @author Bolun
 *
 */
public class solution8 {
	
	public boolean isSubTree(TreeNode T1, TreeNode T2) {
		
		if (T2 == null)
			return true;
		if (T1 == null)
			return false;
		
		if (T1.value == T2.value)
			return isMatched(T1, T2);
		else
			return isSubTree(T1.leftChild, T2.leftChild) || isSubTree(T1.rightChild, T2.rightChild);
	}
	
	public boolean isMatched(TreeNode T1, TreeNode T2) {
		if (T2 == null && T1 == null)
			return true;
		else if (T2 == null && T1 != null)
			return false;
		else if (T1 == null && T2 != null)
			return false;
		else if (T1.value != T2.value)
			return false;
		else
			return isMatched(T1.leftChild, T2.leftChild) && isMatched(T1.rightChild, T2.rightChild);
	}
	
}