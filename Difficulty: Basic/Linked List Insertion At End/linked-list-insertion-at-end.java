/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node insertAtEnd(Node head, int x) {
        // code here
        Node newnode = new Node(x);
        
        if(head == null){
            return newnode;
        }
        
        Node curr = head;
        
        while(curr.next != null){
            curr = curr.next;
        }
        
        curr.next = newnode;
     

        return head;
    }
    
}