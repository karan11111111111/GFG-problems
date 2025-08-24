class Solution {
    public boolean isPalindrome(int n) {
        // code here
        String str = String.valueOf(n);
        String rev = new StringBuilder(str).reverse().toString();
        
        if(str.equals(rev)){
            return true;
        }
        
        return false;
    }
}