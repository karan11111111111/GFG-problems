class Solution {
    // Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preorder(Node root) {
        // write code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        Helper(root, ans);
        return ans;
    }
    
    static void Helper(Node root, ArrayList<Integer> ans){
        if(root == null){
            return;
        }
        
        ans.add(root.data);
        Helper(root.left, ans);
        Helper(root.right, ans);
        
    }
}