// User function Template for Java

class Solution {
    public long countFriendsPairings(int n) {
        // code here
        if(n==1 || n==2){
            return n;
        }


      
        
        
        return countFriendsPairings(n-1) + (n-1)*countFriendsPairings(n-2);
    }
}
