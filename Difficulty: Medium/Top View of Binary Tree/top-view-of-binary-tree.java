/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        // Map to store first node at each horizontal distance
        Map<Integer, Integer> map = new TreeMap<>();

        // Queue for BFS, storing node and its HD
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            Node node = curr.node;
            int hd = curr.hd;

            // If HD not already present, add it (first node at this HD)
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            if (node.left != null) q.add(new Pair(node.left, hd - 1));
            if (node.right != null) q.add(new Pair(node.right, hd + 1));
        }

        // Extracting top view nodes from leftmost to rightmost (TreeMap keeps keys sorted)
        for (int val : map.values()) {
            ans.add(val);
        }

        return ans;
    }
}
