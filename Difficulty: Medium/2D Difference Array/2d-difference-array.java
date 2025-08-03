class Solution {
    public ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] opr) {
        // code here
       
        int v, r1, c1, r2, c2;
       for(int i=0; i<opr.length; i++){
               v = opr[i][0];
               r1 =opr[i][1];
               c1 = opr[i][2];
               r2 = opr[i][3];
               c2 = opr[i][4];
           
           for(int r=r1; r<=r2; r++){
               for(int c=c1; c<=c2; c++){
                   mat[r][c] = mat[r][c]+v;
               }
               
           }
          
       }
       
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        for(int i=0; i<mat.length; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j=0; j<mat[0].length; j++){
                row.add(mat[i][j]);
            }
            result.add(row);
        }
       
       
       return result;
    }
}