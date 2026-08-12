/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        dfs (root);
        return max;
    }

    private int dfs (TreeNode node) {
        if (node == null) return 0;

        int leftHeight = dfs (node.left);
        int rightHeight = dfs (node.right);

        max = Math.max (max, leftHeight + rightHeight);
        return 1 + Math.max (leftHeight, rightHeight);
    }
}
