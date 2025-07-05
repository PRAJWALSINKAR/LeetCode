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
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {   // while we explictly break it run
            // Find the kth node
            ListNode kth = getKthNode(groupPrev.next, k);
            if (kth == null) {
                break;
            }

            ListNode groupNext = kth.next;

            // Disconnect the group to isolate it
            kth.next = null;

            // Reverse the group
            ListNode groupStart = groupPrev.next;
            ListNode reversed = reverse(groupStart);

            // Reconnect reversed group
            groupPrev.next = reversed;
            groupStart.next = groupNext;

            // Move groupPrev to the end of reversed group
            groupPrev = groupStart;
        }

        return dummy.next;
    }

    // Helper to get the kth node from current node
    private ListNode getKthNode(ListNode curr, int k) {
        k -= 1; // Since starting from curr itself
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    // Helper to reverse a linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
}