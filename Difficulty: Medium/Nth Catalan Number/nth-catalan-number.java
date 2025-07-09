
// class Solution {
//     public static int findCatalan(int n) {
//         // code here
//         if(n==0 || n==1){
//             return 1;
//         }
//         int ans =0;
//         for(int i=0; i<n; i++){
//              ans += findCatalan(i) * findCatalan(n-i-1);
//         }
        
//         return ans;
//     }
// }

// class Solution {
//     public static int findCatalan(int n) {
//         // code here
        
//         int dp[] = new int [n+1];
//         Arrays.fill(dp,-1);
        
//         return solve(dp, n);
        
//     }
    
//     private static int solve(int[] dp , int n){
        
//         if(n==0 || n==1){
//             return 1;
//         }
        
//         if(dp[n] != -1){
//             return dp[n];
//         }
        
//         int ans =0;
//         for(int i=0; i<n; i++){
//              ans += solve(dp, i) * solve(dp,n-i-1);
//         }
//         dp[n] = ans;
//         return dp[n];
//     }
// }


class Solution {
    public static int findCatalan(int n) {
        // code here
        
        int dp[] = new int [n+1];
        dp[0] =1;
        dp[1] =1;
        

        for(int i=2; i<=n; i++){
            
           
            
            for(int j=0; j<i; j++){
             dp[i] += dp[j] * dp[i-1-j];
             
            }
           
        }
      
        return dp[n];
    }
}

