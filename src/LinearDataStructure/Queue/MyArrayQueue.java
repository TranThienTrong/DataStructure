package LinearDataStructure.Queue;

public class MyArrayQueue<T> {
    int capacity;
    int size;
    T[] arr;
    int font;
    int rear;

    public MyArrayQueue() {
    }

    public MyArrayQueue(int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
        this.font = 0;
        this.rear = -1;
        this.size = 0;
    }

    boolean isFull() {
        return size == capacity;
    }

    void traversal() {
        for (int i = font; i < size; i++) {
            if (i == font){
                System.out.printf("");
            }
            System.out.println(arr[i]);
        }
    }

    public void enqueue(T item) {
        if (isFull()) {
            System.out.println("Full");
            return;
        }

        rear = (rear + 1) % capacity; // Nếu rear lúc khởi tạo = -1, capital = 10 thì rear lúc này 0
        arr[rear] = item;
        size++;

        System.out.println(arr[rear] + " enqueue");
    }
}
