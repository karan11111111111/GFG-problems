// class Solution {
//     int maxSubarraySum(int[] arr) {
//         // Code here
        
//         int max = Integer.MIN_VALUE;
        
//         for(int i=0; i<arr.length; i++){
//             int sum =0;
//             for(int j=i; j<arr.length; j++){
                
//                 sum = sum+arr[j];
//                 max = Math.max(max, sum);
//             }
//         }
        
//         return max;
//     }
// }
// class Solution {
//     int maxSubarraySum(int[] arr) {
//         // Code here
        
//         int maxsum = Integer.MIN_VALUE;
//         int sum =0;
        
//         for(int i=0; i<arr.length; i++){
//           sum = arr[i] + sum;
           
//           if(sum >= maxsum){
//               maxsum = sum;
//           }
//           if(sum < 0){
//               sum =0;
//           }
           
           
//         }
        
//         return maxsum;
//     }
// }
class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
        
        int sum =0;
        int maxsum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            sum = sum+arr[i];
            
            if(sum > maxsum){
                maxsum = sum;
            }
            
            if(sum < 0){
                sum =0;
            }
        }
        
        return maxsum;
    }
}
