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
    public ListNode oddEvenList(ListNode head) {
    ListNode oddhead = new ListNode(0);
      ListNode evenhead = new ListNode(0);
      
      ListNode odd  = oddhead;
      ListNode even = evenhead;
       ListNode current = head;
       int i =1;
     while(current != null){
   //even nodes at evennode
   if(i%2 == 0 ){
    even.next = current;
    even = even.next;
   }
   //odd at odd
   else{
    odd.next = current;
    odd = odd.next;
   }
   current = current.next;
   i++;
     }
     even.next = null;
     odd.next = evenhead.next;
     return oddhead.next;
    }
}