/*
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // Your code here
    
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    
    if(root ==null){
        return null;
    }
    
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    
    
    while(!q.isEmpty()){
       int levelSize = q.size();
       ArrayList<Integer>level =  new ArrayList<>();
       
       for(int i=0; i<levelSize; i++){
           Node curr = q.poll();
           level.add(curr.data);
           
           if(curr.left !=null) q.add(curr.left);
           if(curr.right !=null) q.add(curr.right);
       }
        
        ans.add(level);
    }
    
    return ans;
    
    }
}