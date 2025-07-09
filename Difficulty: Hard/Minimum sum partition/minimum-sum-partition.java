// User function Template for Java

class Solution {

    public int minDifference(int arr[]) {
        // Your code goes here
        int n = arr.length;
        int sum =0;
        for(int i=0; i<n; i++){
            sum += arr[i];
        }
        
        int W = sum/2;
        
        int dp[][] = new int[n+1][W+1];
        
       
        
        for(int i=1; i<=n; i++){
            for(int j=0; j<=W; j++){
                if(arr[i-1] <=j){ //valid
                    dp[i][j] = Math.max(arr[i-1]+ dp[i-1][j-arr[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        
        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        
        return Math.abs(sum1-sum2);
         
    }
}
