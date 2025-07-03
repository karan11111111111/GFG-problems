//Back-end complete function Template for Java

// class Solution {
//     static int minCostClimbingStairs(int[] cost) {
//         // Write your code here
//         int n = cost.length;
        
        
        
//         return Math.min(fun(cost, n-1),fun(cost, n-2));
//     }
    
//     static int fun(int[] cost, int n){
//         if(n<0){
//             return 0;
//         }
        
//         if(n ==0 || n==1){
//           return cost[n]; 
//         }
        
//         return cost[n] + Math.min(fun(cost, n-1),fun(cost, n-2));
        
        
//     }
// };

class Solution {
    static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(fun(cost, n - 1, dp), fun(cost, n - 2, dp));
    }

    static int fun(int[] cost, int i, int[] dp) {
        if (i < 0) return 0;
        if (i == 0 || i == 1) return cost[i];

        if (dp[i] != -1) return dp[i];

        return dp[i] = cost[i] + Math.min(fun(cost, i - 1, dp), fun(cost, i - 2, dp));
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println("Min cost: " + minCostClimbingStairs(cost)); // Output: 15
    }
}
