class Solution {
    boolean isPalindrome(String s) {
        // code here
        String rev = new StringBuilder(s).reverse().toString();
        return s.equals(rev);
    }
}