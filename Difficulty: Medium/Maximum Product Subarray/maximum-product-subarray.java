// class Solution {
//     int maxProduct(int[] arr) {
//         int n = arr.length;
//         int ans = arr[0];

      
//         for (int i = 0; i < n; i++) {
//             int prod = 1;
//             for (int j = i; j < n; j++) {
//                 prod *= arr[j];
//                 ans = Math.max(ans, prod);
//             }
//         }

//         return ans;
//     }
// }

class Solution {
    int maxProduct(int[] arr) {
        int n = arr.length;
        int maxProd = arr[0];
        int minProd = arr[0];
        int ans = arr[0];

        for (int i = 1; i < n; i++) {
          
            if (arr[i] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

           
            maxProd = Math.max(arr[i], maxProd * arr[i]);
            minProd = Math.min(arr[i], minProd * arr[i]);

            
            ans = Math.max(ans, maxProd);
        }

        return ans;
    }
}
