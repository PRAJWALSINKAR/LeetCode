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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode();
        ListNode great = new ListNode();
        ListNode temps = small;
        ListNode templ = great;
        while(head != null){
            if(head.val  < x){
                temps.next = head;
                temps = head;
                head = head.next;
                temps.next = null;
            }else{
                templ.next = head;
                templ = head;
                head = head.next;
                templ.next = null;
            }
        }
        temps.next = great.next;
        return small.next;
    }
}