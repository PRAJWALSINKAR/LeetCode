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
    public ListNode deleteDuplicates(ListNode head) {

        //for starting repeated modes
        while (head != null && head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            head = head.next;
        }
        ListNode prev = head;
        if (head == null || head.next == null)
            return head;
        ListNode curr = head.next;
        while (curr != null) {
            //
            if (curr != null && curr.next != null && curr.val == curr.next.val) { // if same values
                while (curr != null && curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                curr = curr.next;
                if (curr == null){
                    prev.next = null;
                    return head;
                }

                if (curr != null && curr.next != null && curr.val != curr.next.val) {
                    prev.next = curr;
                    prev = curr;
                    curr = curr.next;
                }
            } else {
                prev.next = curr;
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}