//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to merge two linked lists
    Node merge(Node a, Node b) {
        // If either list is empty, return the other list
        if (a == null) return b;
        if (b == null) return a;

        // Create a dummy node to help with merging
        Node dummy = new Node(0);
        Node tail = dummy;

        // Merge the two lists
        while (a != null && b != null) {
            if (a.data < b.data) {
                tail.bottom = a;
                a = a.bottom;
            } else {
                tail.bottom = b;
                b = b.bottom;
            }
            tail = tail.bottom;
        }

        // Append the remaining nodes
        if (a != null) {
            tail.bottom = a;
        } else {
            tail.bottom = b;
        }

        return dummy.bottom; // Return the merged list, skipping the dummy node
    }

    // Function to flatten a linked list
    Node flatten(Node root) {
        // Base case
        if (root == null) return null;

        // Flatten the next list
        Node nextList = flatten(root.next);

        // Merge current list with flattened next list
        root.next = null; // Make sure the next pointer of the current node is null
        return merge(root, nextList);
    }
}

//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the remaining newline

        while (t-- > 0) {
            String[] workArray = sc.nextLine().trim().split(" ");
            int n = workArray.length;

            Node head = null;
            Node pre = null;

            for (int i = 0; i < n; i++) {
                int m = Integer.parseInt(workArray[i]);
                int data = sc.nextInt();
                Node temp = new Node(data);
                if (head == null) {
                    head = temp;
                    pre = temp;
                } else {
                    pre.next = temp;
                    pre = temp;
                }

                Node preB = temp;
                for (int j = 0; j < m - 1; j++) {
                    int tempData = sc.nextInt();
                    Node tempB = new Node(tempData);
                    preB.bottom = tempB;
                    preB = tempB;
                }
            }

            // Consume the remaining newline if there's any
            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            Solution ob = new Solution();
            Node root = ob.flatten(head);
            printList(root);
        }
        sc.close();
    }
}

// } Driver Code Ends