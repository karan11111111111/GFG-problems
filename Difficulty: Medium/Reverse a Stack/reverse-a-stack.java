// User function Template for Java

class Solution {
    static void reverse(Stack<Integer> s) {
        // base case
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverse(s);  // recursive call
        pushAtBottom(s, top);  // insert at bottom
    }

    static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int temp = s.pop();  // use a different variable name
        pushAtBottom(s, data);
        s.push(temp);
    }
}
