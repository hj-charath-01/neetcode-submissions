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
    public boolean isValidBST(TreeNode root) {
        
        if (root == null) return true;

        return isValid (root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValid (TreeNode node, int min, int max) {
        if (node.val <= min || node.val >= max) return false;

        if (node.left != null && node.right != null) {
            return isValid (node.left, min, node.val) && isValid (node.right, node.val, max);
        }

        if (node.left == null && node.right != null) return isValid (node.right, node.val, max);
        if (node.left != null && node.right == null) return isValid (node.left, min, node.val);

        return true;
    }
}
