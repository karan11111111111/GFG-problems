//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    
    private static int Prec(char ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            
            case '^':
                return 3;
        }
        return -1;
    }
    public static String infixToPostfix(String exp) {
        // Your code here
        String result = new String("");
        
        Stack<Character> stack =new Stack<>();
        
        for(int i=0; i<exp.length(); ++i){
            char c = exp.charAt(i);
            
            if(Character.isLetterOrDigit(c)){
                result +=c;
            }
            
            else if(c=='('){
                stack.push(c);
            }
            
            else if(c==')'){
                while(!stack.isEmpty()&& stack.peek()!='('){
                    result += stack.pop();
                }
                stack.pop();
            }else{
                while(!stack.isEmpty()&&Prec(c) <= Prec(stack.peek())){
                    result += stack.pop();
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek()=='('){
                return "Invalid Expression";
            }
            result += stack.pop();
        }
        return result;
    }
    
    
}