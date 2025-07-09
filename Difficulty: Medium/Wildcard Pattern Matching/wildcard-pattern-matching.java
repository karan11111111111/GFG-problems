class Solution {
    public boolean wildCard(String txt, String pat) {
        // Your code goes here
        
        int n = txt.length();
        int m = pat.length();
        boolean dp[][] = new boolean[n+1][m+1]; 
        //initialization
        dp[0][0] = true;
        // for(int i=1; i<=n; i++){
        //     dp[i][0] = false;
        // }
        
        for(int i=1; i<=m; i++){
            if(pat.charAt(i-1) == '*')
            dp[0][i] = dp[0][i-1];
            else 
            dp[0][i] = false;
        }
        
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                
                char t = txt.charAt(i-1);
                char p = pat.charAt(j-1);
                if(p == '?' || p == t ){
                    dp[i][j] = dp[i-1][j-1];
                }else if( p =='*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j] ;
                }else{
                    dp[i][j] = false;
                }
            }
        }
        
        return dp[n][m];
    }
}