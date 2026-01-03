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
        if(head.next == null)return head;
        if(right == left)return head;
        ListNode curr = head;
        ListNode  tail = null;
        ListNode  rtail = null;
        ListNode  rhead = null;
        ListNode prev = null;
        int count = 1;
        while(curr != null){
            if(count == left - 1)prev = curr;
            if(count == left)rhead = curr;
            if(count == right )rtail = curr;
            if(count == right+1)tail = curr;
            count++;
            curr = curr.next;
        }
        if(prev != null)
        prev.next = null;
        rtail.next = null;
        reverse(rhead);

        if(prev != null)
        prev.next = rtail;
        rhead.next = tail;
        if(rhead == head)return rtail;
        return head;
    }
    public void reverse(ListNode root){
        ListNode dummy = null;
        while(root != null){
        ListNode temp = root;
        root = root.next;
        temp.next = dummy;
        dummy = temp;
        }
    }
}