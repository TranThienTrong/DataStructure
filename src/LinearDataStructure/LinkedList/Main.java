package LinearDataStructure.LinkedList;


import LinearDataStructure.MyDoubleWayNode;

public class Main {

    public static void main(String[] args) {

//        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
//
//        myLinkedList.append(1);
//        myLinkedList.append(2);
//        myLinkedList.append(3);
//        myLinkedList.append(2);
//        myLinkedList.append(2);
//        myLinkedList.append(6);
//        myLinkedList.append(2);
//        myLinkedList.append(2);
//
//
//        myLinkedList.prepend(0);
//
//        myLinkedList.insertAfterIndex(1, 5);
//
////        myLinkedList.deleteNode(3);
////        myLinkedList.deleteNodeAtIndex(2);
//
//
//        myLinkedList.removeDuplicate();
//
//        myLinkedList.insertionSortList();
//
//        myLinkedList.traversal();

        MyDoubleLinkedList<Integer> doubleLinkedList = new MyDoubleLinkedList<>();
        doubleLinkedList.setHead(new MyDoubleWayNode<>(1));
        doubleLinkedList.setHead(new MyDoubleWayNode<>(2));
        doubleLinkedList.setHead(new MyDoubleWayNode<>(3));


        doubleLinkedList.append(5);


        doubleLinkedList.prepend(0);

        //doubleLinkedList.removeNodeWithValue(2);


        //   doubleLinkedList.insertAtPosition(3, new MyDoubleWayNode<>(4));
        // System.out.println(doubleLinkedList.findNodeAtPosition(4));


        doubleLinkedList.insertBefore(doubleLinkedList.findNodeAtPosition(0), new MyDoubleWayNode<>(6));
        doubleLinkedList.insertAfter(doubleLinkedList.findNodeAtPosition(5), new MyDoubleWayNode<>(9));

        doubleLinkedList.removeNode(doubleLinkedList.findNode(6));
        doubleLinkedList.removeNode(doubleLinkedList.findNode(9));

        //  doubleLinkedList.setTail(new MyDoubleWayNode<>(-10));
        // System.out.println(doubleLinkedList.findNode(3));
        doubleLinkedList.traversal();

        doubleLinkedList.getHeadTail();

        //doubleLinkedList.reverseTraversal();


    }
}
