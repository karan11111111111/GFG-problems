//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }

    Node(int d) {
        this.data = d;
        this.next = null;
    } // constructor to create a new node
}

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] numStrings = line.split(" ");
            int[] arr = new int[numStrings.length];
            for (int i = 0; i < numStrings.length; i++) {
                arr[i] = Integer.parseInt(numStrings[i]);
            }
            Solution ob = new Solution();
            Node ans = ob.constructLL(arr);
            while (ans != null) {
                System.out.print(ans.data + " ");
                ans = ans.next;
            }
            System.out.println();
        }
        scanner.close();
    }
}

//Back-end complete function Template for Java

// } Driver Code Ends


// User function Template for Java

/*
class Node {
    int data;
    Node next;

    Node() { data = 0; }
    Node(int d) { data = d; }  //constructor to create a new node
}
*/


class Solution {
    public static Node head;
    
    static Node constructLL(int arr[]) {
        // code here
       head =null;
        
  
        for(int i=arr.length-1; i>=0; i--){
            Node newnode = new Node();
            newnode.next = head;
            newnode.data=arr[i];
            head = newnode;
        }
        
        return head;
      
    }
}
