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
    public int maxDepth(TreeNode root) {
        return getDepth(root, 0);
    }
    
    private int getDepth(TreeNode root, int depth) {
        if (root == null) return depth;
        return Math.max(getDepth(root.left, depth + 1),
            getDepth(root.right, depth + 1));
    }
}
