// User function Template for Java

class Solution {
    // Function to find the difference between the maximum and minimum frequency of
    // elements.
    public int findDiff(int[] arr) {
        // code here
        Map<Integer, Integer> mp = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            
           mp.put(arr[i], mp.getOrDefault(arr[i], 0) +1);
        }
        
        int maxn = Integer.MIN_VALUE;
        int minn= Integer.MAX_VALUE;
        for(int freq: mp.values()){
            maxn = Math.max(maxn, freq);
            minn = Math.min(minn, freq);
            
        }
        
        int dif = maxn- minn;
        return dif;
    }
}