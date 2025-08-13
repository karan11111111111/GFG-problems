// class Solution {
//     public boolean isPalindrome(int n) {
//         // code here
//         String str = String.valueOf(n);
//         String rev = new StringBuilder(str).reverse().toString();
//         if(str.equals(rev)){
//             return true;
//         }
//       return false;
//     }
// }
class Solution {
    public boolean isPalindrome(int n) {
        // code here
      if(n<0 || (n%10 == 0 && n!=0)){
          return false;
      }
      int reversehalf =0;
      
      while(n> reversehalf){
          reversehalf = reversehalf *10 + n%10;
          n /=10;
      }
      
      return (n==reversehalf) || n==reversehalf/10;
    }
}