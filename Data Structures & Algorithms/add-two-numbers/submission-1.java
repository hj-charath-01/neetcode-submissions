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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if (l1 == null && l2 == null) return l2;
        if (l2 == null) return l1;
        if (l1 == null) return l2;

        ListNode result = new ListNode((l1.val + l2.val) % 10);
        ListNode temp = result;

        int carry = (l1.val + l2.val) / 10;

        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            temp.next = new ListNode ((sum + carry) % 10);
            temp = temp.next;
            carry = (sum + carry)/ 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            temp.next = new ListNode ((l1.val + carry) % 10);
            temp = temp.next;
            carry = (l1.val + carry) / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            temp.next = new ListNode ((l2.val + carry) % 10);
            temp = temp.next;
            carry = (l2.val + carry) / 10;
            l2 = l2.next;
        }

        if (carry != 0) {
            temp.next = new ListNode (1);
        }

        return result;
    }
}
