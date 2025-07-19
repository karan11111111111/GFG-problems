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
        preIndex = 0;  // reset index if multiple test cases
        return buildTreeHelper(inorder, preorder, 0, inorder.length - 1);
    }

    private static Node buildTreeHelper(int inorder[], int preorder[], int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // Create the root node from preorder
        Node root = new Node(preorder[preIndex++]);

        // If there's only one element, it's a leaf node
        if (inStart == inEnd) return root;

        // Find the index of this root in inorder
        int inIndex = search(inorder, inStart, inEnd, root.data);

        // Recursively build left and right subtree
        root.left = buildTreeHelper(inorder, preorder, inStart, inIndex - 1);
        root.right = buildTreeHelper(inorder, preorder, inIndex + 1, inEnd);

        return root;
    }

    private static int search(int[] inorder, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == value) return i;
        }
        return -1;  // should never happen
    }
}
