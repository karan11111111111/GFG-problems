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
import java.util.*;

class Solution {
    public boolean isSymmetric(Node root) {
        if (root == null) return true;  // empty tree is symmetric

        ArrayList<Integer> li = new ArrayList<>();
        inorder(root, li);

        return checkpal(li);
    }

    public boolean checkpal(ArrayList<Integer> li) {
        int i = 0, j = li.size() - 1;

        while (i < j) {
            if (!li.get(i).equals(li.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public void inorder(Node root, ArrayList<Integer> li) {
        if (root == null) return;

        inorder(root.left, li);
        li.add(root.data);
        inorder(root.right, li);
    }
}
