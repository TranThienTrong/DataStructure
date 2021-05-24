package LinearDataStructure.LinkedList;

import LinearDataStructure.MyDoubleWayNode;
import LinearDataStructure.MyNode;
import org.w3c.dom.Node;

public class MyDoubleLinkedList<T extends Comparable<T>> implements LinkedList<T> {

    MyDoubleWayNode<T> head;
    MyDoubleWayNode<T> tail;

    @Override
    public void setHead(MyNode<T> node) {
        if (head == null) {
            head = (MyDoubleWayNode<T>) node;
            tail = (MyDoubleWayNode<T>) node;
        } else {
            node.setNextNode(head);
            head = (MyDoubleWayNode<T>) node;
        }
        head.setPrev(null);
    }

    @Override
    public void setTail(MyNode<T> node) {
        if (tail == null) {
            head = (MyDoubleWayNode<T>) node;
            tail = (MyDoubleWayNode<T>) node;
        } else {
            ((MyDoubleWayNode<T>) node).setPrevNode(tail);
            tail = (MyDoubleWayNode<T>) node;
        }
        tail.setNext(null);
    }

    @Override
    public void insertBefore(MyNode<T> node, MyNode<T> newNode) {
        try {
            if (node != null && newNode != null) {
                if (((MyDoubleWayNode<T>) node).getPrev() == null) {
                    head = (MyDoubleWayNode<T>) newNode;
                } else {
                    ((MyDoubleWayNode<T>) newNode).setPrevNode(((MyDoubleWayNode<T>) node).getPrev());
                }
                ((MyDoubleWayNode<T>) newNode).setNextNode((MyDoubleWayNode<T>) node);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void insertAfter(MyNode<T> node, MyNode<T> newNode) {
        try {
            if (node != null && newNode != null) {
                if (((MyDoubleWayNode<T>) node).getNext() == null) {
                    tail = (MyDoubleWayNode<T>) newNode;
                } else {
                    newNode.setNextNode(((MyDoubleWayNode<T>) node).getNext());
                }
                ((MyDoubleWayNode<T>) node).setNextNode(newNode);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertAtPosition(int index, MyNode<T> newNode) {
        try {
            MyDoubleWayNode<T> nodeAtPosition = (MyDoubleWayNode<T>) findNodeAtPosition(index);

            if (nodeAtPosition != null) {
                ((MyDoubleWayNode<T>) newNode).setNextNode(nodeAtPosition.getNext());
                nodeAtPosition.setNextNode(newNode);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeNodeWithValue(T data) {
        MyDoubleWayNode<T> doubleWayNode = (MyDoubleWayNode<T>) this.findNode(data);
        if (doubleWayNode != null) {
            if (doubleWayNode == head) {
                head = head.getNext();
                head.setPrev(null);
            } else if (doubleWayNode == tail) {
                tail = tail.getPrev();
                tail.setNext(null);
            } else {
                doubleWayNode.getPrev().setNext(doubleWayNode.getNext());
            }
        }
    }

    @Override
    public void removeNode(MyNode<T> node) {
        removeNodeWithValue(node.getData());
    }


    @Override
    public void traversal() {
        MyDoubleWayNode<T> currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }


    public void reverseTraversal() {
        MyDoubleWayNode<T> currentNode = tail;
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getPrev();
        }
    }

    @Override
    public void prepend(T data) {
        MyDoubleWayNode<T> newNode = new MyDoubleWayNode<>(data);
        if (head == null) {
            setHead(newNode);
        } else {
            newNode.setNextNode(head);
            setHead(newNode);
        }
    }

    @Override
    public void append(T data) {
        MyDoubleWayNode<T> newNode = new MyDoubleWayNode<>(data);
        if (head == null) {
            setHead(newNode);
        } else {
            MyDoubleWayNode<T> currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNextNode(newNode);
            tail = newNode;
        }
    }

    public void getHeadTail() {
        System.out.println("Head: " + head + "Tail: " + tail);
    }


    /* Helper Function */
    @Override
    public MyNode<T> findNode(T data) {
        if (head == null) {
            System.out.println("Empty List");
            return null;
        } else {
            MyDoubleWayNode<T> currentNode = head;
            while (currentNode != null) {
                if (currentNode.getData().equals(data)) {
                    return currentNode;
                }
                currentNode = currentNode.getNext();
            }

            System.out.println("Cannot Find Node");
            return null;
        }

    }

    public MyNode<T> findNodeAtPosition(int index) {
        if (head == null) {
            System.out.println("Empty List");
            return null;
        } else {
            MyDoubleWayNode<T> currentNode = head;
            int currIndex = 0;
            while (currentNode != null && currIndex <= index) {
                if (currIndex == index) {
                    return currentNode;
                } else {
                    currentNode = currentNode.getNext();
                    currIndex++;
                }
            }
            return null;


        }
    }


}
