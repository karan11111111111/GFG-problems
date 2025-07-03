class Solution {
    public ArrayList<Integer> printDivisors(int n) {
        // code here
       return fun(n, 1 , new ArrayList<>());
    }
    
    public ArrayList<Integer> fun(int n, int i, ArrayList<Integer> list ){
       
        if(i>n){
            return list;
        }
        
        if(n%i==0) list.add(i);
           
        
        return fun(n, i+1, list);
    }
}