/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();   //<original, new>
        Node curr = head;

        while(curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        Node copy = new Node(0);
        Node temp = copy;

        while (curr != null) {
            temp.next = map.get(curr);
            temp = temp.next;

            temp.random = map.get(curr.random);
            curr = curr.next;
        }

        return copy.next;
    }
}
