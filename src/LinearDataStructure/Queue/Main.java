package LinearDataStructure.Queue;

public class Main {

    public static void main(String[] args) {
        MyArrayQueue<Integer> myArrayQueue = new MyArrayQueue<>(4);
        myArrayQueue.enqueue(1);
        myArrayQueue.enqueue(2);
        myArrayQueue.enqueue(3);
        myArrayQueue.enqueue(4);
        myArrayQueue.traversal();

    }
}
