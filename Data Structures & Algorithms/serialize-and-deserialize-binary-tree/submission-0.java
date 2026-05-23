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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "N";
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add (root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.append("N,");
            } else {
                result.append(node.val).append(",");
                queue.offer (node.left);
                queue.offer (node.right);
            }
        }

        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        if (vals[0].equals("N")) return null;

        TreeNode root = new TreeNode (Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add (root);
        int idx = 1;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!vals[idx].equals("N")) {
                node.left = new TreeNode (Integer.parseInt(vals[idx]));
                queue.offer (node.left);
            } idx++;

            if (!vals[idx].equals("N")) {
                node.right = new TreeNode (Integer.parseInt(vals[idx]));
                queue.offer (node.right);
            } idx++;
        }

        return root;
    }
}
