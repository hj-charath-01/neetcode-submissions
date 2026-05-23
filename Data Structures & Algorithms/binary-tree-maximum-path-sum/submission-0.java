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
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftSum = Math.max (0, dfs(root.left));
        int rightSum = Math.max (0, dfs (root.right));

        int currSum = leftSum + root.val + rightSum;
        maxSum = Math.max (currSum, maxSum);

        return root.val + Math.max (leftSum, rightSum);
    }
}
