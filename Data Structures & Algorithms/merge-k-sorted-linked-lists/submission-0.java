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
        if (lists.length == 0) return null;

        for (int i = 1; i < lists.length; i++) {
            lists[i] = mergeTwoLists (lists[i], lists[i - 1]);
        }

        return lists[lists.length - 1];
    }

    private ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists (l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists (l1, l2.next);
                return l2;
            }
        }

        if (l1 == null) return l2;
        return l1;
    }
}
