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
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder (root, list);

        TreeNode node1 = null, node2 = null;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                node2 = list.get(i + 1);
                if (node1 == null) node1 = list.get (i);
                else break;
            }
        }

        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    private void inorder (TreeNode root, List<TreeNode> list) {
        if (root == null) return;

        inorder (root.left, list);
        list.add (root);
        inorder (root.right, list);
    }
}