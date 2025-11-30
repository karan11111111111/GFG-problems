class Solution {
    // Function to calculate factorial of a number.
    int factorial(int n) {
        // code here
        // 5 
        if(n==1){
            return 1; 
        }
       
        return n*factorial(n-1);
    }
}
