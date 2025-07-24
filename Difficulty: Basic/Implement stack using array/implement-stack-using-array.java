class MyStack {
    private int[] arr;
    private int top;

    public MyStack() {
        arr = new int[1000];
        top = -1;
    }

   public boolean isEmpty(){
      return top == -1;
   }
    public void push(int x) {
        // Your Code
        if(top == arr.length-1){
            return;
        }
        
        arr[++top] = x;
        
    }

    public int pop() {
        // Your Code
        
        if(isEmpty()){
            return -1;
        }
        
        
        return arr[top--];
     
    }
}