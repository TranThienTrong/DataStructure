package LinearDataStructure.Queue;

public class ListQueue<T> {

    Node<T> frontNode;
    Node<T> rearNode;
    int capitality;
    int size;

    public ListQueue() {
        this.frontNode = this.rearNode = null;
        this.size = -1;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            frontNode = newNode;
            rearNode = newNode;
        } else {
            rearNode.next = newNode;
            rearNode = newNode;
        }

        System.out.println(newNode + " Pushed");
    }

    public void dequeue() {
        if (frontNode == null) {
            System.out.println("Empty Queue");
            return;
        }
        frontNode = frontNode.next;
        if (frontNode == null) {
            rearNode = null;
        }
    }

    public boolean isEmpty() {
        if (frontNode == null || rearNode == null) {
            return true;
        }
        return false;
    }

    public void traversal() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }


        Node<T> currentNode = frontNode;
        while (currentNode != null) {
            if (currentNode != frontNode && currentNode != rearNode) {
                System.out.print(currentNode + " --> ");
            } else if (currentNode == rearNode) {
                System.out.print("[ " + currentNode.data + " ]" + " Rear");
            } else {
                System.out.print("Front " + "[ " + currentNode.data + " ] --> ");
            }


//            System.out.println(currentNode);
            currentNode = currentNode.next;
        }
    }
}
