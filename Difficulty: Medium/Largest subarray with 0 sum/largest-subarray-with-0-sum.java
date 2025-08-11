// class Solution {
//     int maxLength(int arr[]) {
//         // code here
        
//         int max =0;
        
//         for(int i=0; i<arr.length; i++){
//             int sum=0;
//             for(int j=i; j<arr.length; j++){
//                 sum += arr[j];
//                 if(sum==0){
//                     max = Math.max(max, j-i+1);
//                 }
//             }
//         }
        
//         return max;
//     }
// }


class Solution {
    int maxLength(int arr[]) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int maxi = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Case 1: subarray from index 0 to i has sum 0
            if (sum == 0) {
                maxi = i + 1;
            }
            // Case 2: sum seen before -> zero-sum subarray exists between previous index + 1 and current index
            if (mpp.containsKey(sum)) {
                maxi = Math.max(maxi, i - mpp.get(sum));
            } else {
                // Store the first occurrence of this sum
                mpp.put(sum, i);
            }
        }

        return maxi;
    }
}
