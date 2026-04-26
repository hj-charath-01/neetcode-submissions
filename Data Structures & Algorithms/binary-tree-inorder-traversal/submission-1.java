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

    private List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
        
        result = new ArrayList<>();
        inorder (root);
        return result;
    }

    public void inorder (TreeNode node) {
        if (node == null) return;

        if (node.left != null) inorder (node.left);
        result.add (node.val);
        if (node.right != null) inorder (node.right);
    }
}