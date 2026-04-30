/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue <ListNode> pq = new PriorityQueue<> ((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) pq.add (list);
        }

        ListNode dummy = new ListNode (0);
        ListNode curr = dummy;

        while (pq.size() > 0) {
            curr.next = pq.remove();
            curr = curr.next;

            if (curr.next != null) pq.add (curr.next);
        }

        return dummy.next;
    }
}
