class Solution {
    public static boolean hasTripletSum(int arr[], int target) {
        // code Here
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                for(int k=j+1; k<arr.length; k++){
                    if(arr[i]+arr[j]+arr[k] == target){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}
