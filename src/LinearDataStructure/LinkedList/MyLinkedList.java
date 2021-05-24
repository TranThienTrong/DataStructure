package LinearDataStructure.LinkedList;

import LinearDataStructure.MyNode;

public class MyLinkedList<T extends Comparable<T>> {

    MyNode<T> head, tail;

    public MyLinkedList(MyNode<T> head) {
        this.head = head;
    }

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int size() {
        MyNode<T> currentNode = head;
        int count = 0;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    public void traversal() {
        MyNode<T> currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data.toString());
            currentNode = currentNode.next;
        }
    }


    // Insertion Method

    /* Front */
    public void prepend(T data) {
        MyNode<T> newNode = new MyNode<>(data);
        newNode.next = head;
        head = newNode;
    }

    /* Given Index */

    public void insertAfterIndex(int index, T data) {
        MyNode<T> newNode = new MyNode<>(data);

        MyNode<T> currentNode = head;
        for (int i = 0; i <= size(); i++) {
            if (i == index) {
                newNode.next = currentNode.next;
                currentNode.next = newNode;
            } else {
                currentNode = currentNode.next;
            }
        }next
    }

    /* End */
    public void append(T data) {
        MyNode<T> newNode = new MyNode<>(data);

        if (head == null) {
            head = newNode;
            return;
        }

        if (tail != null) {
            tail.next = newNode;
            tail = newNode;
        } else {
            MyNode<T> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            tail = newNode;
        }
    }

    // Deletion Methods

    /* Delete myNode */
    public void deleteNode(T data) {
        MyNode<T> currentNode = head;
        MyNode<T> previousNode = null;

        if (head.data == data) {
            head = head.next;
            return;
        }

        while (currentNode != null) {
            if (currentNode.data == data) {
                previousNode.next = currentNode.next;
                return;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }
    }

    /* At Index */
    public void deleteNodeAtIndex(int index) {
        MyNode<T> currentNode = head;
        MyNode<T> prevNode = null;

        if (index == 0) {
            head = head.next;
            return;
        }

        for (int i = 0; i <= size(); i++) {
            if (i == index) {
                prevNode.next = currentNode.next;
            } else {
                prevNode = currentNode;
                currentNode = currentNode.next;

            }
        }
    }


    // Sort

    public void bubbleSortLinkedList() {
        if (head == null) {
            return;
        }

        MyNode<T> currentNode = head;
        MyNode<T> indexNode = null;

        while (currentNode != null) {
            indexNode = currentNode.next;

            while (indexNode != null) {

                if (currentNode.compareTo(indexNode) > 0) {
                    T temp = indexNode.data;
                    indexNode.data = currentNode.data;
                    currentNode.data = temp;
                }
                indexNode = indexNode.next;
            }

            currentNode = currentNode.next;
        }

    }

//

    public void insertionSortList() {


        MyNode<Integer> pivot = (MyNode<Integer>) head.next;

        // Loop while head exists
        while (pivot != null) {


            MyNode<Integer> current = (MyNode<Integer>) head;
            while (current != pivot) {

                if (pivot.compareTo(current) < 0) {
                    int temp = current.data;
                    current.data = pivot.data;
                    pivot.data = temp;
                }

                current = current.next;
            }

            pivot = pivot.next;
        }

    }


    public void removeDuplicates1() { // Chỉ có tác dụng với các element gần nhau
        MyNode<T> current = this.head;
        while (current != null) {
            MyNode<T> nextNode = current.next;
            while (nextNode != null && nextNode.compareTo(current) == 0) {

                nextNode = nextNode.next;
            }

            current.next = nextNode;
            current = current.next;
        }
    }

    public void removeDuplicate() {
        //myNode current will point to head
        MyNode<T> current = head;
        MyNode<T> nextNode = null;
        MyNode<T> prev = null;

        if (head == null) {
            return;
        }

        while (current != null) {
            //myNode temp will point to previous node to index.
            prev = current;
            //Index will point to node next to current
            nextNode = current.next;

            while (nextNode != null) {
                //If current node's data is equal to index node's data
                if (current.data == nextNode.data) {
                    //Here, index node is pointing to the node which is duplicate of current node
                    //Skips the duplicate node by pointing to next node
                    prev.next = nextNode.next;
                    nextNode = nextNode.next;
                } else {
                    //Temp will point to previous node of index.
                    prev = nextNode;
                    nextNode = nextNode.next;
                }
            }
            current = current.next;
        }
    }


}







