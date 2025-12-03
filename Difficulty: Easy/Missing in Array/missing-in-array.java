// class Solution {
//     int missingNum(int arr[]) {
//         // code here
//         Set<Integer> st = new HashSet<>();
        
//         for(int a: arr){
//             st.add(a);
//         }
        
//         for(int i=1; i<=arr.length; i++){
            
//             if(!st.contains(i)){
//                 return i;
//             }
            
            
//         }
        
//         return arr.length+1;
//     }
// }

class Solution {
    int missingNum(int arr[]) {
        // code here
        int n = arr.length+1;
        long expectedsum = (long)n*(n+1)/2L;
        long sum = 0L;
        for(int a: arr){
            sum = sum+ a;
            
        }
        
        
      
        long missing = expectedsum-sum;
        return (int)missing;
    }
}