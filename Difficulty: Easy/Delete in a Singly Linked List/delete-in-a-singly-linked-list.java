/* Linklist node structure
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/
class Solution {
    Node deleteNode(Node head, int x) {
        // code here
        
      if(head == null ){
         return null;
      }
        
        if(x==1){
            return head.next;
        }
     
          
        Node curr = head;
     
      for(int i=1; curr != null && i<x-1; i++){
          curr = curr.next;
      }
        
        if(curr ==null|| curr.next==null){
            return head;
        }
        
        
        curr.next = curr.next.next;
        return head;
    }
}