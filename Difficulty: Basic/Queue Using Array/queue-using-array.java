// class MyQueue {

//     int front, rear;
//     int arr[] = new int[100005];

//     MyQueue() {
//         front = 0;
//         rear = 0;
//     }

//     // Function to push an element x in a queue.
//     void push(int x) {
//         // Your code here
//         arr[rear++] =x;
        
//     }

//     // Function to pop an element from queue and return that element.
//     int pop() {
        
//         // Your code here
//         if(front == rear){
//             return -1;
//         }
        
//         return arr[front++];
        
//     }
// }

class MyQueue {
    int front, rear, size;
    int capacity = 100005;
    int[] arr = new int[capacity];

    MyQueue() {
        front = 0;
        rear = 0;
        size = 0;
    }

    // Function to push an element x in a queue.
    void push(int x) {
        if (size == capacity) {
            // Queue is full
            return;
        }
        arr[rear] = x;
        rear = (rear + 1) % capacity;
        size++;
    }

    // Function to pop an element from queue and return that element.
    int pop() {
        if (size == 0) {
            // Queue is empty
            return -1;
        }
        int result = arr[front];
        front = (front + 1) % capacity;
        size--;
        return result;
    }
}
