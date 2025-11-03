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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null ||  head.next == null)return head;
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
    
        ListNode L = dummyHead;
        for(int i = 1 ; i < left ; i++){
            L = L.next;
        }

        ListNode R = dummyHead;
        for(int i = 0 ; i <= right ; i++){
            R = R.next;
        }
        ListNode dummy = R;
        
        ListNode curr = L.next;
        int count = right - left+1;

        while(count > 0){

            ListNode temp = curr;
            curr = curr.next;
            temp.next = dummy;
            dummy = temp;
            count--;
        }
        L.next = dummy;

        return dummyHead.next;
    }
}