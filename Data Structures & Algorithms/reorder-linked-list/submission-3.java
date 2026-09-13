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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverseList(slow.next);
        slow.next = null;

        mergeTwoLists(head, rev);
    }

    private ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private void mergeTwoLists(ListNode A, ListNode B) {
        while(A != null && B!= null) {
            ListNode nextA = A.next, nextB = B.next;

            A.next = B;
            if(nextA != null) {
                B.next = nextA;
            }

            A = nextA;
            B = nextB;
        }
    }
}
