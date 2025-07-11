// class Solution {
//     static int minJumps(int[] arr) {
//         int n = arr.length;
//         int result = solve(arr, 0, n);
//         return result == Integer.MAX_VALUE ? -1 : result;
//     }

//     private static int solve(int[] arr, int index, int n) {
//         if (index >= n - 1) return 0; // Reached or passed end
//         if (arr[index] == 0) return Integer.MAX_VALUE; // Can't move

//         int minJumps = Integer.MAX_VALUE;

//         for (int jump = 1; jump <= arr[index]; jump++) {
//             int subResult = solve(arr, index + jump, n);
//             if (subResult != Integer.MAX_VALUE) {
//                 minJumps = Math.min(minJumps, 1 + subResult);
//             }
//         }

//         return minJumps;
//     }
// }


// class Solution {
//     static int minJumps(int[] arr) {
//         int n = arr.length;

//         if (n <= 1) return 0;
//         if (arr[0] == 0) return -1;

//         int jumps = 1;
//         int maxReach = arr[0];
//         int steps = arr[0];

//         for (int i = 1; i < n; i++) {
//             if (i == n - 1) return jumps;

//             maxReach = Math.max(maxReach, i + arr[i]);
//             steps--;

//             if (steps == 0) {
//                 jumps++;
//                 if (i >= maxReach) return -1;
//                 steps = maxReach - i;
//             }
//         }

//         return -1;
//     }

// }


class Solution {
    static int minJumps(int[] arr) {
        int n = arr.length;

        int dp[]  = new int [n];
        Arrays.fill(dp,-1);
        
        dp[n-1] =0;
        for(int i=n-2; i>=0; i--){
            int steps = arr[i];
            int ans = Integer.MAX_VALUE;
            for(int j=i+1; j<=i+steps && j<n; j++){
                if(dp[j] != -1){
                    ans = Math.min(ans, dp[j]+1);
                }
            }
            
            if(ans != Integer.MAX_VALUE){
                dp[i] = ans;
            }
        }
        
        return dp[0]; 
    }

}
