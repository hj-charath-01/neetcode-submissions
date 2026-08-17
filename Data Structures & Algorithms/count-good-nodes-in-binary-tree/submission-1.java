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
    public int goodNodes(TreeNode root) {
        if (root.left == null && root.right == null) return 1;

        return 1 + dfs (root.left, root.val) + dfs (root.right, root.val);
    }

    private int dfs (TreeNode curr, int prevVal) {
        if (curr == null) {
            return 0;
        }

        int count = 0;
        if (curr.val >= prevVal) {
            count++;
        }

        return count + dfs (curr.left, Math.max(curr.val, prevVal)) + dfs (curr.right, Math.max(curr.val, prevVal));
    }
}
