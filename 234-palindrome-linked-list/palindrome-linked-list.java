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
 // int privious sumbition when we use recursion it will take an extra space and extra time 
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
      ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}