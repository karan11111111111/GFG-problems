class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        Set<Integer> st = new HashSet<>();
        int secondlargest = Integer.MIN_VALUE;
        int largest = Integer.MIN_VALUE;
        for(int i =0; i<arr.length; i++){
            st.add(arr[i]);
        }
      
        for(int a : st){
            if(a > largest ){
                secondlargest = largest;
                largest = a;
            }else if(a> secondlargest){
                secondlargest = a;
            }
        }
        
        return secondlargest;
    }
    
}