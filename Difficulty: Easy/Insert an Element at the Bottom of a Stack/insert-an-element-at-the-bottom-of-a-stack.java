// User function Template for Java
class Solution {
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        
        Stack<Integer> stack = new Stack<>();

        while(!st.isEmpty()){
            int a = st.pop();
            stack.push(a);
        }
        st.push(x);
        
        while(!stack.isEmpty()){
            int a = stack.pop();
            st.push(a);
        }
        
        return st;
    }
}