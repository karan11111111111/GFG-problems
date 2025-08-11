// class Solution {
//     public int maxWater(int arr[]) {
//         int n = arr.length;
//         int totalWater = 0;

//         for (int i = 0; i < n; i++) {
          
//             int leftMax = 0;
//             for (int j = 0; j <= i; j++) {
//                 leftMax = Math.max(leftMax, arr[j]);
//             }

         
//             int rightMax = 0;
//             for (int j = i; j < n; j++) {
//                 rightMax = Math.max(rightMax, arr[j]);
//             }

            
//             totalWater += Math.min(leftMax, rightMax) - arr[i];
//         }

//         return totalWater;
//     }
// }

class Solution {
    public int maxWater(int arr[]) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    totalWater += leftMax - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else {
                    totalWater += rightMax - arr[right];
                }
                right--;
            }
        }
        return totalWater;
    }
}
