// class Solution {
//     static int knapsack(int W, int val[], int wt[]) {
//         // code here
//         int n = val.length;
        
//         return solve(val, wt, W, n);
//     }
    
//     public static int solve(int[] val, int [] wt, int W, int n){
        
//         if(W==0 || n==0){
//             return 0;
//         }
        
//         if(wt[n-1] <=W){// valid
        
//         int include = val[n-1]+ solve(val, wt, W-wt[n-1],n-1);
//         int exclude = solve(val, wt,W,n-1);
        
//         return Math.max(include, exclude);
            
//         }else{ // invalid
//             return solve(val, wt,W,n-1);
//         }
//     }
// }

class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        
        int [][]dp = new int[n+1][W+1];
        
        for(int i=0; i<=n; i++){
        Arrays.fill(dp[i],-1);
        }
        
        return solve(dp, val, wt, W, n);
    }
    
    public static int solve(int [][]dp, int[] val, int [] wt, int W, int n){
        
        if(W==0 || n==0){
            return 0;
        }
        
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(wt[n-1] <=W){// valid
        
        int include = val[n-1]+ solve(dp, val, wt, W-wt[n-1],n-1);
        int exclude = solve(dp, val, wt,W,n-1);
        
        return dp[n][W] = Math.max(include, exclude);
            
        }else{ // invalid
            return dp[n][W] = solve(dp, val, wt,W,n-1);
        }
    }
}


