class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer>li = new ArrayList<>();
        for(int i=0;i<arr.length; i++){
            boolean isleader =true;
            for(int j=i+1; j< arr.length; j++){
                if(arr[i]< arr[j]){
                    isleader=false;
                   break;
                }
            }
            if(isleader){
                li.add(arr[i]);
            }
        }
        
        return li;
    }
}
