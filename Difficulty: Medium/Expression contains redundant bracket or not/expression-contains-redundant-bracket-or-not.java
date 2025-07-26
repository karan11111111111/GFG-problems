import java.util.Stack;

class Solution {
    public static int checkRedundancy(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                boolean operatorFound = false;

              
                while (!st.isEmpty() && st.peek() != '(') {
                    char top = st.pop();
                    // Check if it's one of the operators
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        operatorFound = true;
                    }
                }

                // Pop the matching '('  
                if (!st.isEmpty()) {
                    st.pop();
                }

                // If no operator found inside, it's redundant
                if (!operatorFound) {
                    return 1;
                }

            } else {
                // Push everything else
                st.push(ch);
            }
        }

        // No redundant parentheses found
        return 0;
    }

  
}
