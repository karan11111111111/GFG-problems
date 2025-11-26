class Solution {
    public void reverseArray(int arr[]) {
        // code here
        int i=0;
        int n= arr.length-1;
        while(i<n){
            int temp = arr[n];
            arr[n] = arr[i];
            arr[i]=temp;
            i++;
            n--;
        }
    }
}