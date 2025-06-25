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
 
 //my approch
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode curr = head;
        int size =0;
        while(curr != null){
        size++;
        curr = curr.next;
        }

        size = size/2;
        curr = head;
        while(size > 0){
            size--;
        curr = curr.next;
        }

        return curr;
    }
}