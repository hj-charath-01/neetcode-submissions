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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List <List <Integer>> result = new ArrayList<>();
        Queue <TreeNode> queue = new LinkedList<>();

        queue.offer (root);

        while (!queue.isEmpty()) {
            int nodeCount = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < nodeCount; i++) {
                TreeNode curr = queue.poll();
                if (curr == null) continue;
                queue.offer (curr.left);
                queue.offer (curr.right);
                list.add (curr.val); 
            }

            if (list.size() != 0) result.add (new ArrayList<> (list));
        }

        return result;
    }
}
