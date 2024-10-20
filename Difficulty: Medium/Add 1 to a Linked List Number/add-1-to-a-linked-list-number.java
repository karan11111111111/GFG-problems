//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


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
    public Node addOne(Node head) {
        // Step 1: Reverse the linked list
        head = reverse(head);

        // Step 2: Add one to the number
        Node temp = head;
        int carry = 1; // Initial carry since we're adding one

        while (temp != null) {
            int sum = temp.data + carry;
            temp.data = sum % 10; // Update current node with new value
            carry = sum / 10; // Determine the new carry

            // If there's no carry, we can break early
            if (carry == 0) break;

            // Move to the next node
            if (temp.next == null && carry > 0) {
                // If we reach the end and there's still carry, add a new node
                temp.next = new Node(carry);
                carry = 0; // No more carry to propagate
            }

            temp = temp.next;
        }

        // Step 3: Reverse the list again to restore the original order
        head = reverse(head);

        return head; // Return the updated head of the list
    }

    // Helper function to reverse the linked list
    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next; // Store next node
            curr.next = prev; // Reverse current node's pointer
            prev = curr;      // Move pointers one position forward
            curr = next;
        }

        return prev; // New head of the reversed list
    }
}
