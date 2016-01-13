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
        
        int res = 1 * compareWithNextNode(head, head.next);
        
        if (res == 0)
            return true;
        else
            return false;
    }
    
    private int compareWithNextNode(ListNode first, ListNode node) {
        if (node == null)
            return 1;
        
        if (first == node.next)
            return 0;
        else
            return 1 * compareWithNextNode(first, node.next);
        
    }
}
