class MyStack {
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }
    StackNode top;

    // Function to push an integer into the stack.
    
     boolean isEmpty(){
         
        return top == null;
     }
    void push(int a) {
        // Add your code here
        StackNode newnode =  new StackNode(a);
       
        newnode.next = top;
        top = newnode;
        
    }

    // Function to remove an item from top of the stack.
    int pop() {
        // Add your code here
        
        if(isEmpty()){
            return -1;
        }
        
        int t = top.data;
        top = top.next;
        return t;
    }
}