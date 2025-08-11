class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        // code here
        
        int n = arr.length;
        Set<ArrayList<Integer>> s = new HashSet<>();
        
        for(int i=0; i<n-3; i++){
            for(int j=i+1; j<n-2; j++){
                for(int k=j+1; k<n-1; k++){
                    for(int l=k+1; l<n; l++){
                        int sum = arr[i]+arr[j]+arr[k]+arr[l];
                        if(sum == target){
                           ArrayList<Integer> li = new ArrayList<>();
                            li.add(arr[i]);
                            li.add(arr[j]);
                            li.add(arr[k]);
                            li.add(arr[l]);
                            Collections.sort(li);
                            s.add(li);
                        }
                    }
                }
            }
        }
        
        return new ArrayList<>(s);
    }
}