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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> rightSide = new ArrayList<>();

        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int val = 0;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                val = curr.val;

                if (curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }

            rightSide.add(val);
        }

        return rightSide;
    }
}
