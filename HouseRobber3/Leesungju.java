/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	Map<TreeNode, List<Integer>> dp; 
	public int rob(TreeNode root) {
		dp = new HashMap<>();
		int t = rob(root, false);
		int f = rob(root, true);
		return Math.max(t, f);
	}
	
	public int rob(TreeNode root, boolean rob) {
		List<Integer> dpValue = dp.get(root);
		if (dpValue != null) {
			int value = rob ? dpValue.get(0) : dpValue.get(1);
			if (value != -1) return value;
		}
		if (root == null) return 0;

		int max = rob(root.left, true) + rob(root.right, true);
		if (rob) {
			max = Math.max(max, rob(root.left, false) + rob(root.right, false) + root.val);
		}
		
		if (dpValue == null) {
			dpValue = new ArrayList<>();
			dpValue.add(-1); dpValue.add(-1);
			dp.put(root, dpValue);
		}
		if (rob) {
			dpValue.set(0, max);
		} else {
			dpValue.set(1, max);
		}
		return max;
	}
}
