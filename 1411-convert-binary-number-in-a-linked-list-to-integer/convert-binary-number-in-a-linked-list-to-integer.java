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
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        List<Integer> lis = new ArrayList<>();
        while(temp != null){
            lis.add(temp.val);
            temp = temp.next;
        }
        int count = lis.size() -1 ; 
        int ans = 0;
        for(int i : lis){
            ans +=Math.pow(2 , count--) * i;
        }
        return ans;
    }
}