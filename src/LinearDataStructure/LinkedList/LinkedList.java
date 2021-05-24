package LinearDataStructure.LinkedList;

import LinearDataStructure.MyNode;

public interface LinkedList<T extends Comparable<T>> {
    void setHead(MyNode<T> node);

    void setTail(MyNode<T> node);

    void insertBefore(MyNode<T> node, MyNode<T> newNode);

    void insertAfter(MyNode<T> node, MyNode<T> newNode);

    void insertAtPosition(int index, MyNode<T> newNode);

    void removeNodeWithValue(T data);

    void removeNode(MyNode<T> node);

    void traversal();

    void prepend(T data);

    void append(T data);

    MyNode<T> findNode(T data);
    MyNode<T> findNodeAtPosition(int index);
}
