/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/
/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node swapKth(Node head, int k) {
        if (head == null) return null;

        // Count length of linked list
        int n = 0;
        Node temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // If k is more than number of nodes
        if (k > n) return head;

        // If kth node from start and end are same, no swap needed
        if (2 * k - 1 == n) return head;

        // Find kth node from start and its previous
        Node prev1 = null, curr1 = head;
        for (int i = 1; i < k; i++) {
            prev1 = curr1;
            curr1 = curr1.next;
        }

        // Find kth node from end (i.e. (n-k+1)th node from start)
        Node prev2 = null, curr2 = head;
        for (int i = 1; i < n - k + 1; i++) {
            prev2 = curr2;
            curr2 = curr2.next;
        }

        // If previous nodes exist, adjust their next pointers
        if (prev1 != null) prev1.next = curr2;
        if (prev2 != null) prev2.next = curr1;

        // Swap next pointers of curr1 and curr2
        Node tempNext = curr1.next;
        curr1.next = curr2.next;
        curr2.next = tempNext;

        // If k == 1, new head is curr2
        if (k == 1) head = curr2;

        // If k == n, new head is curr1
        if (k == n) head = curr1;

        return head;
    }
}
