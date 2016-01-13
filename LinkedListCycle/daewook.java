/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        return compareWithNextNode(head, head.next);
    }
    
    private boolean compareWithNextNode(ListNode first, ListNode node) {
        if (node == null || node.next = null)
            return false;
        
        if (first == node.next)
            return true;
        else
            return compareWithNextNode(first.next, node.next.next);
        
    }
}


////// commit test