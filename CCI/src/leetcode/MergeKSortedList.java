package leetcode;

import java.util.ArrayList;
import amazon.ListLoopQuestion.ListNode;

public class MergeKSortedList {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (lists == null || lists.size() == 0) return null;
        
        ListNode newhead = null;
        ListNode newp = null;
        // make sure there is node left
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                newhead = new ListNode(0);
                newp = newhead;
                break;
            }
        }
        
        int flag = 1;
        while (flag == 1) {
            flag = 0; // reset the flag
            // find the min
            int minrecord = Integer.MAX_VALUE;
            for (int i = 0; i < lists.size(); i++) {
                if ( lists.get(i) != null) {
                    if (lists.get(i).value < minrecord) minrecord = lists.get(i).value;
                }
            }
            // move ahead for the min and add to new list
            for (int i = 0; i < lists.size(); i++) {
                if ( lists.get(i) != null) {
                    if (lists.get(i).value == minrecord) {
                        newp.value = lists.get(i).value;
                        ListNode p = lists.get(i);
                        p = p.next; 
                        lists.set(i, p); // pointer moves
                        break;
                    }
                }
            }
            // detect whehter there is node left
            for (int i = 0; i < lists.size(); i++) {
                if (lists.get(i) != null) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                newp.next = new ListNode(0);
                newp = newp.next; // new list pointer moves
            }
        }
        
        return newhead;
    }
}