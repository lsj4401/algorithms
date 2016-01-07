public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode turtle = head;
        ListNode rabbit = head.next;
        
        while (turtle != null && rabbit != null) {
          if (turtle == rabbit) return true;
          turtle = turtle.next;
          rabbit = rabbit.next == null ? null : rabbit.next.next;
        }
        
        return false;
    }
}
