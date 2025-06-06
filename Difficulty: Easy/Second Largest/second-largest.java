class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        TreeSet<Integer> set = new TreeSet <>();
        
        for(int a: arr){
            set.add(a);
        }
        
        if(set.size() <2){
            return -1;
        }
        
        set.pollLast();
        
        return set.last();
    }
}