package LinearDataStructure.Queue;

public class ArrayQueue {
    int front;
    int rear;
    int[] array;
    int capitality;
    int size;


    public ArrayQueue(int capitality) {
        this.capitality = capitality;
        this.array = new int[capitality];
        this.rear = -1;
        this.front = this.size = 0;
    }


    public ArrayQueue() {
        this.capitality = 100;
        this.array = new int[capitality];
        this.rear = capitality - 1;
        this.front = this.size = 0;
    }

    public boolean isFull() {
        return (this.size == this.capitality);
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }


    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Full");
            return;
        }

        rear = (rear + 1) % capitality; // Nếu rear lúc khởi tạo = -1, capital = 10 thì rear lúc này 0
        array[rear] = item;
        size++;

        System.out.println(array[rear] + " enqueue");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        this.front = (front + 1) % capitality;
        this.size--;
        System.out.println(array[front - 1] + " dequeue");
    }


    public void traversal() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }

        for (int i = front; i <= rear; i++) {

            if (i != front && i != rear) {
                System.out.print(array[i]  + " --> ");
            } else if (i == rear) {
                System.out.print("[ "+array[i] +" ]" + " Rear");
            } else if (i == front) {
                System.out.print("Front " +"[ "+ array[i]+ " ] --> ");
            }
        }
    }
}
