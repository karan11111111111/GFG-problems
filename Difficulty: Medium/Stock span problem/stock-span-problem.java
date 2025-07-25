
// class Solution {
//     public ArrayList<Integer> calculateSpan(int[] arr) {
//         // write code here
//         ArrayList<Integer> span = new ArrayList<>();
        
//         Stack<Integer> st = new Stack<>();
        
//         for(int i=0; i <arr.length; i++){
//             while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
//                 st.pop();
//             }
            
//             if(st.isEmpty()){
//                 span.add(i+1);
//             }else{
//                 span.add(i-st.peek());
//             }
            
//             st.push(i);
//         }
        
        
//         return span;
//     }
// }
// import java.util.ArrayList;

// class Solution {
//     public ArrayList<Integer> calculateSpan(int[] arr) {
//         int n = arr.length;
//         ArrayList<Integer> span = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             int count = 1;
//             // Go backward and count days with price ≤ current day's price
//             for (int j = i - 1; j >= 0; j--) {
//                 if (arr[j] <= arr[i]) {
//                     count++;
//                 } else {
//                     break;
//                 }
//             }
//             span.add(count);
//         }

//         return span;
//     }
// }


import java.util.*;

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> span = new ArrayList<>(Collections.nCopies(n, 0));

        span.set(0, 1);  // First day span is always 1

        for (int i = 1; i < n; i++) {
            int counter = 1;

            // Jump back using previous spans
            while ((i - counter) >= 0 && arr[i] >= arr[i - counter]) {
                counter += span.get(i - counter);
            }

            span.set(i, counter);
        }

        return span;
    }
}
  


