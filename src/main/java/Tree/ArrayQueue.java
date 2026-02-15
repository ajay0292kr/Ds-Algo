package Tree;

public class ArrayQueue {
    private int []arr;
    private int front;
    private int rear;
    private int capacity;

    public ArrayQueue(int size) {
        capacity = size;
        front = 0;
        rear = -1;
        arr = new int[capacity];
    }

    // Insert element
    public void enqueue(int value) {
        if (isFull()) {
            System.out.print("Queue is Full. Can't insert" + value);
        }
        arr[++rear] = value;
        System.out.print(value + "inserted into queue");
    }
    // Remove an element
    public int dequeue() {
        if (isEmpty()) {
            System.out.print("Queue is Empty");
            return -1;
        }
        int value = arr[front++];
        System.out.print(value + "removed from queue");
        return value;
    }
    // Peek front
    public int peek() {
        if (isEmpty()) {
            System.out.print("Queue is Empty");
            return -1;
        }
        return arr[front];
    }
    public boolean isEmpty() {
        return front > rear;
    }
    public boolean isFull() {
        return rear == capacity - 1;
    }

    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front element: " + q.peek());

        q.dequeue();
        q.dequeue();

        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60); // This may show full even if space exists
    }
}
