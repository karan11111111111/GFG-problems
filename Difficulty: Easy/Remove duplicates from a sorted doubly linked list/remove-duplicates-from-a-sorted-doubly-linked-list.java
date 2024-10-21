//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String args[]) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine().trim());
            Node head, tail;
            String s[] = br.readLine().trim().split(" ");
            int x = Integer.parseInt(s[0]);
            head = new Node(x);
            tail = head;
            for(int i = 1;  i < n; i++){
                x = Integer.parseInt(s[i]);
                Node temp = new Node(x);
                tail.next = temp;
                temp.prev = tail;
                tail = temp;
            }
            Solution soln = new Solution();
            head = soln.removeDuplicates(head);

            if(verify(head))
                displayList(head);
            else
                ot.println("Your pointers are not correctly connected");
            
        }
        ot.close();
    }
    static boolean verify(Node head){
        int fl = 0, bl = 0;
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
            fl++;
        }
        while(temp.prev != null){
            temp = temp.prev;
            bl++;
        }
        return fl == bl;
    }
    static void displayList(Node head){
        while(head.next != null){
            ot.print(head.data + " ");
            head = head.next;
        }
        ot.println(head.data);
    }
}
class Node{
    int data;
    Node next, prev;
    Node(int x){
        this.data = x;
        this.next = null;
        this.prev = null;
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    Node removeDuplicates(Node head) {
        // If the list is empty or has only one node, return as no duplicates exist.
        if (head == null || head.next == null) return head;

        Node p = head; // Pointer to track the current unique node.
        Node n = head.next; // Pointer to the next node to check for duplicates.

        while (n != null) {
            // If the current node (p) and next node (n) have different data, move forward.
            if (p.data != n.data) {
                p.next = n; // Link the current unique node (p) to the next unique node (n).
                n.prev = p; // Update the `prev` pointer for the next unique node in a doubly linked list.
                p = p.next; // Move the unique pointer forward.
            }
            // Move the checking pointer forward to continue looking for the next unique node.
            n = n.next;
        }

        // Once all duplicates are removed, set the last unique node's `next` pointer to null.
        p.next = null;

        return head;
    }
}
