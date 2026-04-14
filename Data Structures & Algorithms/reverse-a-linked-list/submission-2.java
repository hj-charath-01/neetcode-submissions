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
    public ListNode reverseList(ListNode head) {
        
        if (head == null || head.next == null) return head;

        Stack <Integer> stack = new Stack<>();

        while (head != null) {
            stack.push (head.val);
            head = head.next;
        }

        ListNode temp = new ListNode (stack.pop());
        head = temp;

        while (!stack.isEmpty()) {
            temp.next = new ListNode (stack.pop());
            temp = temp.next;
        }

        return head;
    }
}
