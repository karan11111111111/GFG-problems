
class Solution {
    static boolean isBalanced(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(ch== '(' || ch== '{' || ch== '['){
                st.push(ch);
            }else if(ch == ')' || ch=='}' || ch == ']'){
              if(st.isEmpty()){
                  return false;
              }
               char top = st.pop();
               if (!isMatchingPair(top, ch)) return false;
            }
        }
      
        
        return st.isEmpty();
    }
    
     static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
    
}
