class Solution {
    // Function to remove duplicates from the given array.
    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        ArrayList<Integer> li = new ArrayList<>();
        li.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(arr[i] != arr[i-1]){
                li.add(arr[i]);
            }
        }
        
        return li;
    }
}
