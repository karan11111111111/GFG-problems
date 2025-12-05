class Solution {
    // Function to remove duplicates from the given array.
    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        ArrayList<Integer>li = new ArrayList<>();
        
        Set<Integer> st = new HashSet<>();
        
        for(int a: arr){
            st.add(a);
        }
        
        for(int i : st){
            li.add(i);
        }
        
        Collections.sort(li);
        
        return li;
    }
}
