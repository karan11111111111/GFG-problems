class Solution {
    int minCost(int[] height) {
        // code here
        
        
        int n = height.length;
        int[] dp = new int[n];
        dp[0] =0;
        
        for(int i=1; i<n; i++){
            int onestep = dp[i-1]+ Math.abs(height[i] - height[i-1]);
            int twostep = Integer.MAX_VALUE;
            
            if(i >1)
            twostep = dp[i-2] + Math.abs(height[i] - height[i-2]);
        dp[i] = Math.min(onestep, twostep);
        }
        
        return dp[n-1];
        
    }
}