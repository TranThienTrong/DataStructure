package LinearDataStructure;

public abstract class MyNode<T extends Comparable<T>> implements Comparable<MyNode<T>>{
    protected T data;
    protected MyNode<T> nextNode;

    public MyNode(T data, MyNode<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public MyNode(T data) {
        this.data = data;
    }

    public MyNode() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public abstract void setNextNode(MyNode<T> nextNode);

    @Override
    public int compareTo(MyNode<T> o) {
        return this.data.compareTo(o.data);
    }
}

