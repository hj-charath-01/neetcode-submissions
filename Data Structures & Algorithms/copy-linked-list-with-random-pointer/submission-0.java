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
        HashMap <Node, Node> map = new HashMap<>();
        
        Node temp = head;
        while (temp != null){
            map.put (temp, new Node (temp.val));
            temp = temp.next;
        }

        temp = head;
        Node result = new Node(0);
        Node temp2 = result;
        while (temp != null) {
            temp2.next = map.get(temp);
            temp2 = temp2.next;

            temp2.next = map.get(temp.next);
            temp2.random = map.get(temp.random);
            
            temp = temp.next;
        }

        return result.next;
    }
}
