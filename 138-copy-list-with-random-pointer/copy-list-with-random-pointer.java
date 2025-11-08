/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node , Node > map = new HashMap<>();
        Node curr = head;
        Node dummy = new Node(-1);
        Node prev = dummy;
        while(curr != null){
            Node temp = new Node(curr.val);
            map.put(curr , temp);
            prev.next = temp;
            prev = temp;
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            if(curr.random != null){
                map.get(curr).random = map.get(curr.random);
            }
            
            curr = curr.next;
        }

        return  dummy.next;
    }
}