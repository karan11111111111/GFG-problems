/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        // code here
        if(node ==null){
            return -1;
        }
        
        int lh = height(node.left);
        int rh = height(node.right);
        
        int ht = 1 + Math.max(lh, rh);
        
        return ht;
    }
}