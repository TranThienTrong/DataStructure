package LinearDataStructure;

public class MyDoubleWayNode<T extends Comparable<T>> extends MyNode<T> {

    MyDoubleWayNode<T> prev;
    MyDoubleWayNode<T> next;

    public MyDoubleWayNode(T data, MyDoubleWayNode<T> next, MyDoubleWayNode<T> prev) {
        super(data);
        this.next = next;
        this.prev = prev;
    }

    public MyDoubleWayNode(T data) {
        this.data = data;
    }

    public MyDoubleWayNode() {
        super();
    }

    public MyDoubleWayNode<T> getPrev() {
        return prev;
    }

    public MyDoubleWayNode<T> getNext() {
        return next;
    }

    public void setNext(MyDoubleWayNode<T> next) {
        this.next = next;
    }

    public void setPrev(MyDoubleWayNode<T> prev) {
        this.prev = prev;
    }

    public void setPrevNode(MyDoubleWayNode<T> prevNode) {
        this.prev = prevNode;
        prevNode.setNext(this);
    }

    @Override
    public void setNextNode(MyNode<T> nextNode) {
        this.next = (MyDoubleWayNode<T>) nextNode;
        ((MyDoubleWayNode<T>) nextNode).setPrev(this);
    }

    @Override
    public String toString() {
        return "{" +
                " data: " + data +
                " } ";
    }
}
