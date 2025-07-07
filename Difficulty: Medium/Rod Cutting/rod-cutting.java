class Solution {
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int dp[][] = new int[n+1][n+1];
        
        for(int i=0; i<n+1; i++){
            dp[i][0] = 0;
        }
        for(int i=0; i<n+1; i++){
            dp[0][i] = 0;
        }
        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                
                if(i<=j){
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-i],dp[i-1][j]);
                }else{ 
                    dp[i][j] = dp[i-1][j];
                }
                
            }
        }
        
        return dp[n][n];
    }

}