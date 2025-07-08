class Solution {
    int stringConversion(String X, String Y) {
        // **1) If Y contains any lowercase, it's impossible.**
        for (char cy : Y.toCharArray()) {
            if (Character.isLowerCase(cy)) {
                return 0;
            }
        }
        
        int n = X.length(), m = Y.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        // You can delete X[0..i-1] to get empty Y only if they are all lowercase:
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i-1][0] && Character.isLowerCase(X.charAt(i-1));
        }

        // Build the DP
        for (int i = 1; i <= n; i++) {
            char cx = X.charAt(i-1);
            for (int j = 1; j <= m; j++) {
                char cy = Y.charAt(j-1);  // guaranteed uppercase now

                if (cx == cy) {
                    // exact upper ↔ upper match
                    dp[i][j] = dp[i-1][j-1];
                }
                else if (Character.isLowerCase(cx) && Character.toUpperCase(cx) == cy) {
                    // either capitalize-to-match or delete
                    dp[i][j] = dp[i-1][j-1]  // capitalize & match
                               || dp[i-1][j]; // delete cx
                }
                else if (Character.isLowerCase(cx)) {
                    // delete cx
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    // uppercase cx that doesn't match cy → dead end
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m] ? 1 : 0;
    }
}
