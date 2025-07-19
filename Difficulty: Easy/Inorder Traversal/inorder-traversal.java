/* A Binary Tree node

class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        // Code
        ArrayList<Integer> ans = new ArrayList<>();
        
      Helper(root,ans);
       return ans;
    }
    
    void Helper(Node root, ArrayList<Integer>ans){
        
        if(root == null){
            return;
        }
        
        Helper(root.left, ans);
        ans.add(root.data);
        Helper(root.right, ans);
        
        
        
        
        
    }
    
}