class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
        
       int sum = 0;
       int maxsum = Integer.MIN_VALUE; // -infy
       
                            // 2, 3, -8, 7, -1, 2, 3
       
       for(int i=0; i<arr.length; i++){ // i=6
           sum = sum+arr[i];  //  sum =  8 + 3 = 11
           
           if(sum > maxsum){
               maxsum = sum;  // maxsum = 11
           }
            
           if(sum <0){ // -3
               sum =0; // sum =0;
           }
       }
        
      return maxsum;
    }
}
