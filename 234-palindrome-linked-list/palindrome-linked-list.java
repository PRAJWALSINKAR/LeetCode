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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        if(slow.next == null)return true;
        ListNode fast = head.next;
        if(fast.next == null){
            return slow.val == fast.val;
        }
        int count =1;
        while(fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
        ListNode dummy = null;
        ListNode curr = slow.next;

        while(curr != null){
            ListNode prev = curr;
            curr = curr.next;
            prev.next = dummy;
            dummy = prev;
        }
        curr = head;
        while(count > 0){
            if(curr.val != dummy.val)return false;
            curr = curr.next;
            dummy = dummy.next;
            count--;
        }
        return true;
    }
}