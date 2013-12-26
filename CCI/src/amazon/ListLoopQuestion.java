package amazon;

/* My approach is use two pointers moving in different pace so as to detect whether
 * there is collision for these two pointers. If there is collision, there is loop;
 * if not, there is not.
 */

/* Enter your Big O Analysis here. */
 
/* Enter your code here. */

public class ListLoopQuestion {

    public static class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int val) {
        	value = val;
        }
    }
    /**
     * determine whether the two nodes are the same by looking its K subsequent nodes
     * The larger the K is, the more confident we can say they are the same nodes given
     * non distinct integer value
     * @param n1: first node
     * @param n2: second node
     * @param K: number of subsequent nodes to look
     * @return result: true if they are same, false if they are not
     */
    public static boolean isSame( ListNode n1, ListNode n2, int K) {
        
        if (n1 == null && n2 == null)
            return true;
        if ((n1 == null && n2 != null) || (n1 != null && n2 == null))
            return false;
        
        ListNode p1 = n1;
        ListNode p2 = n2;
        boolean result = true;
        int count = 0;
        
        while (p1 != null && p2 != null && count < K) {
            if (p1.value != p2.value) {
                result = false;
                break;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
            count += 1;
        }
        return result;
    }
    
    public static boolean hasLoops( ListNode myList ) {
        if (myList == null)
            return false;
        
        ListNode n1 = myList; // fast runner
        ListNode n2 = myList; // slow runner
        
        boolean result = false;
        
        while (n1 != null && n1.next != null) {
            n1 = n1.next.next;
            n2 = n2.next;
            if (n1.value == n2.value) {
                // determine whether its following 100 nodes are the same or not
                boolean is = isSame(n1, n2, 100);
                if (is == true) {
                    result = true;
                    break;
                } else {
                    continue;
                }
            }
        }
        return result;
    }

}