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
        //first We found out an middle
        if(head == null || head.next == null)return true;
        ListNode slow  = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
       //reverse  2nd half
      ListNode newHead = reverse(slow.next);
       ListNode first = head;
       ListNode secound = newHead;
       while(secound != null){
        if(first.val != secound.val)return false;
        first = first.next;
        secound = secound.next;
       }
       return true;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newhead = reverse(head.next);

        ListNode frount = head.next;
        frount.next = head;

        head.next = null;

        return newhead;
         

    }
}