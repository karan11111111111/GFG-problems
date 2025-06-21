class Solution {
    static int countFactors(int n) {
        // code here
        
        return solve(n,1);
    }
    
    private static int solve(int n, int i){
        if(i>n){
            return 0;
        }
        
        if(n%i == 0){
            return 1 + solve(n, i+1);
        }else{
            return solve(n,i+1);
        }
    }
}