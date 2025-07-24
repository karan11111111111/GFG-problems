
class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // write code here
        ArrayList<Integer> span = new ArrayList<>();
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i <arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                span.add(i+1);
            }else{
                span.add(i-st.peek());
            }
            
            st.push(i);
        }
        
        
        return span;
    }
}
        


