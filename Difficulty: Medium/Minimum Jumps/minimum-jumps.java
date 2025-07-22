// class Solution {
//     static int minJumps(int[] arr) {
//         int n = arr.length;
//         int result = solve(arr, 0, n);
//         return result == Integer.MAX_VALUE ? -1 : result;
//     }

//     static int solve(int[] arr, int index, int n) {
//         if (index >= n - 1) return 0;
//         if (arr[index] == 0) return Integer.MAX_VALUE;

//         int minJumps = Integer.MAX_VALUE;
//         for (int i = 1; i <= arr[index]; i++) {
//             int jumps = solve(arr, index + i, n);
//             if (jumps != Integer.MAX_VALUE) {
//                 minJumps = Math.min(minJumps, 1 + jumps);
//             }
//         }
//         return minJumps;
//     }
// }


class Solution {
    static int minJumps(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        // Initialize dp array with -1 meaning not computed yet
        for (int i = 0; i < n; i++) dp[i] = -1;
        
        int result = solve(arr, 0, n, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    static int solve(int[] arr, int index, int n, int[] dp) {
        if (index >= n - 1) return 0;
        if (arr[index] == 0) return Integer.MAX_VALUE;
        if (dp[index] != -1) return dp[index];

        int minJumps = Integer.MAX_VALUE;
        for (int jump = 1; jump <= arr[index]; jump++) {
            int next = solve(arr, index + jump, n, dp);
            if (next != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, 1 + next);
            }
        }
        dp[index] = minJumps;
        return dp[index];
    }
}

