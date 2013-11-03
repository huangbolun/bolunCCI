package tree_and_graphs;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * convert a binary tree with depth D into D linked list
 * assuming there is no extra-field in the treenode to keep track of the depth
 * in this case, use recursive call instead
 * @author Bolun
 *
 */
public class solution4 {
	
	LinkedList<LinkedList<TreeNode>> lists;

	public solution4() {
		lists = new LinkedList<LinkedList<TreeNode>>();
	}
	
	/**
	 * 
	 * @param root
	 * @param lists a list of lists for each depth
	 * @param level initial value should be 0
	 */
	public void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		
		if (root == null) {
			return;
		}
		
		LinkedList<TreeNode> list = null;
		
		/* THIS condition is very important */
		if (lists.size() == level) {
			list = new LinkedList<TreeNode>();
			lists.add(list);
		} else
			list = lists.get(level);
		
		createLevelLinkedList(root.leftChild, lists, level+1);
		createLevelLinkedList(root.rightChild, lists, level+1);
	}
	
	public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root, result, 0);
		return result;
	}
	
	public ArrayList<LinkedList<TreeNode>> createLevelLinkedListBFS(TreeNode root, ArrayList<LinkedList<TreeNode>> lists) {
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		
		if (root == null)
			return null;
		
		if (queue.isEmpty())
			queue.offer(root);
		
		while (!queue.isEmpty())
		{
			LinkedList<TreeNode> thisLevel = new LinkedList<TreeNode>();
			LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
			
			Iterator<TreeNode> it = queue.iterator();
			
			while (it.hasNext())
			{
				TreeNode n = it.next();
				thisLevel.offer(n);
				nextLevel.offer(n.leftChild);
				nextLevel.offer(n.rightChild);
			}
			
			queue.clear();
			queue.addAll(nextLevel);
			lists.add(thisLevel);
		}
		
		return lists;
	}
	
}