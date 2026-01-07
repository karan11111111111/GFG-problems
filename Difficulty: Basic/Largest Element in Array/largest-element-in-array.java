class Solution {
    public static int largest(int[] arr) {
        // code here
        int max=0;
        for(int i=0; i<arr.length; i++){
            int curr = arr[i];
            
            if(curr>max){
                max = curr;
            }
        }
        
        return max;
    }
}
