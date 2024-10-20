//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        next = prev = null;
    }
}

class DLinkedList {

    Node newNode(Node head, int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            return head;
        }
        head.next = n;
        n.prev = head;
        head = n;
        return head;
    }

    void printList(Node node) {
        Node temp = node;
        while (temp.next != null) {
            temp = temp.next;
        }

        while (temp.prev != null) {
            temp = temp.prev;
        }

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {

        DLinkedList DLL = new DLinkedList();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t > 0) {
            Node temp;
            Node head = null;
            Node root = null;
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(str[i]);
                head = DLL.newNode(head, x);
                if (root == null) root = head;
            }
            head = root;

            String str2[] = read.readLine().trim().split(" ");
            int pos = Integer.parseInt(str2[0]);
            int data = Integer.parseInt(str2[1]);

            Solution g = new Solution();
            head = g.addNode(head, pos, data);

            DLL.printList(head);
            while (head.next != null) {
                temp = head;
                head = head.next;
            }
            t--;
        }
    }
}
// } Driver Code Ends


/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/

class Solution {
    // Function to insert a new node at a given position in a doubly linked list.
    Node addNode(Node head, int p, int x) {
        // Create the new node with the value x
        Node newnode = new Node(x);

        // If the head is null, just return the new node as the new head
        if (head == null) {
            return newnode;
        }

        // Start at the head and find the node at position p
        Node curr = head;
        for (int i = 0; i < p; i++) {
            if (curr.next == null) {
                break; // Prevent going out of bounds if p exceeds list length
            }
            curr = curr.next;
        }

        // Insert the new node after the current node
        newnode.next = curr.next; // new node's next is current's next
        newnode.prev = curr;      // new node's previous is current
        
        if (curr.next != null) {
            curr.next.prev = newnode; // Update the next node's previous pointer
        }
        
        curr.next = newnode; // Update the current node's next pointer to newnode
        
        // Return the head of the updated list
        return head;
    }
}
