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
    public ListNode swapNodes(ListNode head, int k) {
        int size= 0;
        ListNode curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }
        ListNode first = head;
        ListNode secound = head;
        for(int i = 1 ; i<k ; i++)first = first.next;

        int n = size - k; // secound node position 

        for(int i = 0 ; i<n ; i++)secound = secound.next;

        int temp = first.val;
        first.val = secound.val;
        secound.val = temp;

        return head; 


    }
}