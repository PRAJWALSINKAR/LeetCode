/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr = head;
        Node back = null;

        while(curr  != null){
            if(curr.child != null){
                back = curr.next;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                curr.next = flatten(curr.next); 
                while(curr.next != null){
                     curr = curr.next;
                }
                if(back != null){
                    curr.next = back;
                    back.prev = curr;
                }
            } 
            curr = curr.next;
        }
        
        return head;
    }
}