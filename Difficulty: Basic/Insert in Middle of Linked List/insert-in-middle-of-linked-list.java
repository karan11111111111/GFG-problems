/*
Structure of node class is:
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    public Node insertInMiddle(Node head, int x) {
        Node newNode = new Node(x);

        // Empty list, new node becomes head
        if (head == null) return newNode;

        Node slow = head, fast = head;

        // Move fast by 2 steps, slow by 1 step
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Insert new node after slow
        newNode.next = slow.next;
        slow.next = newNode;

        return head;
    }
}
