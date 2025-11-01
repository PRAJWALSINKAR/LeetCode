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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }

        ListNode curr = head;
        ListNode dummy = new ListNode();
        ListNode prev = dummy;

        while(curr != null){
            if(!set.contains(curr.val)){
                prev.next = curr;
                prev = prev.next;
            }else{
                prev.next = null;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}