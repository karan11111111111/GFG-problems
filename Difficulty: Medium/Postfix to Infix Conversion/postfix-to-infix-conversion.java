//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        // Stack to store operands and intermediate infix expressions
        Stack<String> stack = new Stack<>();

        // Traverse the postfix expression from left to right
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // If the character is an operand, push it to the stack
            if (Character.isLetterOrDigit(ch)) {
                stack.push(Character.toString(ch));
            } 
            // If the character is an operator
            else {
                // Pop two operands from the stack
                String operand2 = stack.pop();
                String operand1 = stack.pop();

                // Form the infix expression and push back to the stack
                String infix = "(" + operand1 + ch + operand2 + ")";
                stack.push(infix);
            }
        }

        // The remaining element in the stack is the infix expression
        return stack.peek();
    }
}
