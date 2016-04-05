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
    public int rob(TreeNode root) {
        int currDepth = 0;
        
        // totalOfOddDepth = root.val;
        
        traverseTree(root, currDepth);
        return Math.max(totalOfOddDepth, totalOfEvenDepth);
    }
    
    private int totalOfOddDepth = 0;
    private int totalOfEvenDepth = 0;
    
    private void traverseTree(TreeNode node, int depth) {
        if (node == null)
            return;
        
        traverseTree(node.left, depth + 1);
        
        if (depth % 2 == 0) 
            totalOfOddDepth += node.val;
        else
            totalOfEvenDepth += node.val;
            
        traverseTree(node.right, depth + 1);
    }
}