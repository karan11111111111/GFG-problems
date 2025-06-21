// recursion

// class Solution {
//     int countWays(int n) {
//         // your code here
//         if(n==1){
//             return 1;
//         }
        
//         return countWays(n-1)+ countWays(n-2);
//     }
// }

// Memoization


// class Solution {
//     int countWays(int n) {
//         // your code here
       
        
//         int[] dp = new int[n+1];
//         Arrays.fill(dp,-1);
        
//         return solve(n,dp);
        
      
//     }
    
//     private int solve(int n, int dp[]){
        
//          if(n==0){
//             return 1;
//         }
//          if(n==1){
//             return 1;
//         }
        
//         if(dp[n] != -1) return dp[n];
//       return dp[n] = solve(n-1, dp) + solve(n-2, dp);
//     }
// }


// Tabulation

class Solution {
    int countWays(int n) {
        // your code here
        if(n==1){
            return 1;
        }
        
        int [] dp = new int[n+1];
        
        dp[0] =1;
        
        dp[1] = 1;
        
        
       for(int i=2; i<=n; i++){
           dp[i] = dp[i-1]+dp[i-2]; 
       }
       
       return dp[n];
    }
}

