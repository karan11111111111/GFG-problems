/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

// class Solution {
//     int diameter(Node root) {
//         if (root == null) return 0;

//         int lh = height(root.left);
//         int rh = height(root.right);
        
//         int ld = diameter(root.left);
//         int rd = diameter(root.right);
        
//         int selfDiameter = lh + rh + 2;  

//         return Math.max(selfDiameter, Math.max(ld, rd));
//     }

//     int height(Node node) {
//         if (node == null) return -1;
//         return 1 + Math.max(height(node.left), height(node.right));
//     }
// }

class Solution {

    static class Info {
        int diam;
        int ht;
        Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info helper(Node root) {
        if (root == null) return new Info(0, -1);  // ht = -1 for edges

        Info left = helper(root.left);
        Info right = helper(root.right);

        int ht = 1 + Math.max(left.ht, right.ht);
        int diam = Math.max(Math.max(left.diam, right.diam), left.ht + right.ht + 2);  // edges

        return new Info(diam, ht);
    }

    int diameter(Node root) {
        return helper(root).diam;
    }
}
