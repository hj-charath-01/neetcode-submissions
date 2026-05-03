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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode curr = head;
        int group = 0;

        while (curr != null && group < k) {
            curr = curr.next;
            group++;
        }

        if (group == k) {
            curr = reverseKGroup (curr, k);

            while (group-- > 0) {
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
            }

            head = curr;
        }

        return head;
    }
}
