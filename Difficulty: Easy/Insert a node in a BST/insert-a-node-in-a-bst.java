class Solution {
    // Function to insert a node in a BST.
    Node insert(Node root, int Key) {
        if (root == null) {
            return new Node(Key);
        }

        if (Key < root.data) {
            root.left = insert(root.left, Key);
        } else if (Key > root.data) {
            root.right = insert(root.right, Key);
        }
        // else: Key == root.data → do nothing to prevent duplicates

        return root;
    }
}
