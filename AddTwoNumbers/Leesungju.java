/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode root = node;
        int add = 0;
        while (true) {
            int sum = getValue(l1) + getValue(l2) + add;
            add = sum / 10;
            node.val = sum % 10;
            l1 = nextNode(l1); l2 = nextNode(l2);
            if (l1 == null && l2 == null && add == 0) break;
            node = node.next = new ListNode(add);
        }
        
        return root;
    }
    
    private int getValue(ListNode n) {
        if (n != null) return n.val;
        return 0;
    }
    
    private ListNode nextNode(ListNode n) {
        return n == null ? null : n.next;
    }
}
