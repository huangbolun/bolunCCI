package leetcode;

import leetcode.IsValidBST.TreeNode;
import leetcode.PartitionList.ListNode;

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        int[] num = ListtoArray(head);
        TreeNode root = toBST(num, 0, num.length-1);
        return root;
    }
    
    public TreeNode toBST(int[] num, int begin, int end) {
        if (begin > end) return null;
        if (begin == end) return new TreeNode(num[begin]);
        int mid = (begin + end) / 2;
        TreeNode tmp = new TreeNode(num[mid]);
        tmp.left = toBST(num, begin, mid-1);
        tmp.right = toBST(num, mid+1, end);
        return tmp;
    }
    
    public int[] ListtoArray(ListNode head) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len += 1;
        }
        int[] num = new int[len];
        p = head;
        int i = 0;
        while (p != null) {
            num[i] = p.val;
            p = p.next;
            i++;
        }
        return num;
    }
}