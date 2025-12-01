class Solution {
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // code here
        ArrayList<Integer> row =new ArrayList<>();
        
        row.add(1);
        for(int i=1; i<n; i++){
            
        ArrayList<Integer> newrow =new ArrayList<>();
        newrow.add(1);
            
            for(int j=1; j<i; j++){
                
              
                
                newrow.add(row.get(j-1)+row.get(j));
            }
            
            newrow.add(1);
            row = newrow;
        }
        
        return row;
    }
}