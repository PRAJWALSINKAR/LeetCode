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
        if (k == 1 || head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode back = dummy;
        ListNode start = head;
        ListNode curr = head;

        while (curr!= null) {

            int count = 0;
            while (curr != null && count < k) {
                curr = curr.next;
                count++;
            }
            if (count < k) break;
            ListNode backtemp = null;
            ListNode end = start;
            while (end != curr) {
                ListNode x = end.next;
                end.next = backtemp;
                backtemp = end;
                end = x;
            }

            
            back.next = backtemp;
            start.next = curr;

            
            back = start;
            start = curr;
        }

        return dummy.next;
    }
}
