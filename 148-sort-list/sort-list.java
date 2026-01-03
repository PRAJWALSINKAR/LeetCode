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
    public ListNode sortList(ListNode head) {
        if(head == null)return null;
        if(head.next == null)return head;
        ListNode slow = head;
        ListNode fast  =head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode nn = slow.next; 
        slow.next = null;
        ListNode first= sortList(head);
        
        ListNode sec =sortList(nn);
        
        //merge
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode currf = first;
        ListNode currs = sec;
        while(currf != null && currs != null){
            if(currf.val < currs.val){
                ListNode temp = currf;
                currf = currf.next;
                temp.next = null;
                curr.next = temp;
                curr = curr.next;
            }else{
                ListNode temp = currs;
                currs = currs.next;
                temp.next = null;
                curr.next = temp;
                curr = curr.next;
            }
        }
        while(currf != null){
            ListNode temp = currf;
            currf = currf.next;
            temp.next = null;
            curr.next = temp;
            curr = curr.next;
        }
        while(currs != null){
            ListNode temp = currs;
            currs = currs.next;
            temp.next = null;
            curr.next = temp;
            curr = curr.next;
        }
    return dummy.next;
    }
}