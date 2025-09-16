/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    static int preIndex = 0;

    public static Node buildTree(int inorder[], int preorder[]) {
        preIndex = 0; 
        return build(inorder, preorder, 0, inorder.length - 1);
    }

    private static Node build(int[] inorder, int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

       
        Node root = new Node(preorder[preIndex++]);

      
        if (inStart == inEnd) {
            return root;
        }

        
        int inIndex = search(inorder, inStart, inEnd, root.data);

      
        root.left = build(inorder, preorder, inStart, inIndex - 1);
        root.right = build(inorder, preorder, inIndex + 1, inEnd);

        return root;
    }

   
    private static int search(int[] inorder, int start, int end, int val) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == val) return i;
        }
        return -1;
    }
}
