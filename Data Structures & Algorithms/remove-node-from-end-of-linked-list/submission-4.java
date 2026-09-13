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
        ListNode dummy = new ListNode(0, head);
        ListNode rear = dummy, front = head;
        while(n-- > 0) {
            front = front.next;
        }

        while(front != null) {
            rear = rear.next;
            front = front.next;
        }

        rear.next = rear.next.next;
        return dummy.next;
    }
}
