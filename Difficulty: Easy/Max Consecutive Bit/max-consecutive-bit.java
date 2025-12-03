class Solution {
    public int maxConsecBits(int[] arr) {
        // code here
        
        int onec=0;
        int zeroc =0;
        int maxo =0;
        int maxz =0;
        for(int i=0; i<arr.length; i++){
                
            if(arr[i] == 1 ){
              onec++;
                if(onec >maxo){
                    maxo = onec;
                }
                zeroc =0;
            }else if(arr[i] ==0){
                zeroc++;
                if(zeroc> maxz){
                    maxz = zeroc;
                }
                onec =0;
            }
            
        }
        
        return Math.max(maxo, maxz);
    }
}
