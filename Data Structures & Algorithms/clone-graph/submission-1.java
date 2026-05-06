/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> copy = new HashMap<>();

        return dfs (node, copy);
    }

    private Node dfs (Node node, Map<Node, Node> copy) {
        if (node == null) {
            return null;
        }

        if (copy.containsKey (node)) {
            return copy.get (node);
        }

        Node curr = new Node (node.val);
        copy.put (node, curr);

        for (Node neighbor : node.neighbors) {
            curr.neighbors.add (dfs (neighbor, copy));
        }

        return curr;
    }
}