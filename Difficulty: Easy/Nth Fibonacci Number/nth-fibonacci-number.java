// User function Template for Java

// class Solution {
//     public int nthFibonacci(int n) {
//         // code here
        
//         if(n==0||n==1){
//             return n;
//         }
//             return nthFibonacci(n-1)+ nthFibonacci(n-2);
//     }
// }


class Solution {
    public int nthFibonacci(int n) {
        // code here
        
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        
        return solve(dp,n);
    }
    
    private int solve(int dp[], int n){
        
        if(n==0||n==1){
            return n;
        }
        
        if(dp[n]!=-1){
            return dp[n];
        }
            return dp[n] = nthFibonacci(n-1)+ nthFibonacci(n-2);
        
    }
}