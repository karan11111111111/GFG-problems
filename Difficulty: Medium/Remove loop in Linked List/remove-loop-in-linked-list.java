/*
class Node
{
    int data;
    Node next;
}
*/

class Solution {
    public static void removeLoop(Node head) {
        Node slow = head, fast = head;
        boolean isCycle = false;

        // Step 1: Detect cycle using Floyd's algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;  // Important: exit immediately after detection
            }
        }

        // No cycle found
        if (!isCycle) return;

        // Step 2: Find start of loop
        slow = head;
        Node prev = null;

        // Special case: loop starts at head
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
            return;
        }

        // General case
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: Break the loop
        prev.next = null;
    }
}
