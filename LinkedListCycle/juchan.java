import test.ListNode;

public class Solution {
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;

		ListNode one, two;

		one = head;
		two = head;

		while (true) {

			one = one.next; 

			if (two.next != null)
				two = two.next.next; 
			else
				return false; 

			if (one == null || two == null) 
				return false;

			if (one == two) 
				return true;
		}
	}
}