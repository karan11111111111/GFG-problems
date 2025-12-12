class Solution {
    int majorityElement(int arr[]) {
        // code here
        
        int candidate =0;
        int count =0;
        
        for(int i=0; i<arr.length; i++){
            if(count ==0){
                candidate = arr[i];
                count =1;
            }else if(candidate == arr[i]){
                count++;
            }else{
                count--;
            }
        }
        
        int freq =0;
        
        for(int a: arr){
            if(a == candidate){
                freq++;
            }
        }
        
        return (freq>arr.length/2 ? candidate : -1);
        
    }
}