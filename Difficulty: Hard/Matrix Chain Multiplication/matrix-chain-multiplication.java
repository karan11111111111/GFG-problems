// class Solution {
//     static int matrixMultiplication(int arr[]) {
//         // code here
        
//       int n = arr.length;
        
//         return mcm(arr, 1,n-1);
//     }
    
//     static int mcm(int[]arr, int i, int j){
//         if(i==j){ //single matrix case. we can't multiply a single matrix.
//         return 0;}
        
//         int ans = Integer.MAX_VALUE;
//         for(int k=i; k<j; k++){
//             int cost1 = mcm(arr,i,k); //Ai....Ak => arr[i-1] x arr[k]
//             int cost2 = mcm(arr,k+1,j); // Ai+1...Aj => arr[k] x arr[j]
//             int cost3 = arr[i-1] * arr[k] * arr[j];
            
//           int  finalcost  = cost1+cost2+cost3;
//           ans = Math.min(ans,finalcost);
//         }
        
//         return ans; //mincost
        
//     }
// }
class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here
        
       int n = arr.length;
       
       int dp[][] = new int[n][n];
       for(int i=0; i<n; i++){
       Arrays.fill(dp[i],-1);
       }
        
        return mcm(dp, arr, 1,n-1);
    }
    
    static int mcm(int dp[][], int[]arr, int i, int j){
        if(i==j){ //single matrix case. we can't multiply a single matrix.
        return 0;}
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int cost1 = mcm(dp, arr,i,k); //Ai....Ak => arr[i-1] x arr[k]
            int cost2 = mcm(dp, arr,k+1,j); // Ai+1...Aj => arr[k] x arr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j];
            
           int  finalcost  = cost1+cost2+cost3;
           ans = Math.min(ans,finalcost);
        }
        
        dp[i][j] = ans;
        
        return dp[i][j]; //mincost
        
    }
}