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
        ListNode dummy = null;
        ListNode curr = head;
        ListNode Rhead = null;
        ListNode start = null;
        ListNode prev = null;
        int count = 1;
        ListNode temp = null;
        if(k ==1)return head;
        while(curr != null){
            if(count % k == 1)Rhead = curr;
            
            boolean status = true;
            if(count % k == 0){
                ListNode Rtail =  null;
                Rtail = curr;
                temp = curr.next;
                curr = curr.next;
                status = false;
                Rtail.next = null;
                reverse(Rhead);
                if(start == null){
                    start = Rtail;
                    prev = Rhead;
                }else{
                     prev.next = Rtail;
                     prev = Rhead;
                }
            }
            if(status)
            curr = curr.next;
            count++;
        }
        if(temp != null)prev.next = temp;
        return start;
    }
    public void reverse(ListNode root){
          ListNode curr = root;
          ListNode dummy = null;
          while(curr != null){
          ListNode temp = curr;
          curr = curr.next;
          temp.next = null;
          temp.next = dummy;
          dummy = temp;
        }
    }
}