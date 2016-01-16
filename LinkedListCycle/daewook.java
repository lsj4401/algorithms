// Linked List Cycle
// Given a linked list, determine if it has a cycle in it.
// Follow up:
// Can you solve it without using extra space?

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