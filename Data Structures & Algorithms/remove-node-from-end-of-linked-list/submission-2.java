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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode (0, head);
        ListNode front = head;
        ListNode back = temp;

        while (n > 0) {
            front = front.next;
            n--;
        }

        while (front != null) {
            front = front.next;
            back = back.next;
        }

        back.next = back.next.next;
        return temp.next;
    }
}
