// User function Template for Java

class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        // add your code here
        
        int n = arr.length;
        
        d=d%n;
        
        reverse(arr, 0, d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
    }
    
    static void reverse(int arr[], int i, int n){
        
       
        while(i<n){
            
            int temp = arr[i];
            arr[i] = arr[n];
            arr[n] = temp;
            
            i++;
            n--;
        }
    }
}