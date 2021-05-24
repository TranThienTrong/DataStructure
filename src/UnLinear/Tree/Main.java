package UnLinear.Tree;

public class Button.Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(1);
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        AVL<Integer> avlTree = new AVL<>();



//        binarySearchTree.insert(5);
//        binarySearchTree.insert(3);
//        binarySearchTree.insert(7);
//        binarySearchTree.insert(2);
//        binarySearchTree.insert(4);
//        binarySearchTree.insert(6);
//        binarySearchTree.insert(8);

        binarySearchTree.insertRec(5);
        binarySearchTree.insertRec(3);
        binarySearchTree.insertRec(7);
        binarySearchTree.insertRec(2);
        binarySearchTree.insertRec(4);
        binarySearchTree.insertRec(6);
        binarySearchTree.insertRec(8);
        binarySearchTree.insertRec(9);
        binarySearchTree.insertRec(10);

        avlTree.root = avlTree.insert(avlTree.root, 10);
        avlTree.root = avlTree.insert(avlTree.root,20);
        avlTree.root = avlTree.insert(avlTree.root,30);
        avlTree.root = avlTree.insert(avlTree.root,40);
        avlTree.root = avlTree.insert(avlTree.root,50);
        avlTree.root = avlTree.insert(avlTree.root,25);

/*
        10
          \
          20
            \
            30
              \
              40                             30
                \                         /      \
                 50                     20       50
                /                      / \       /
              25                      10 25    40
*/

      avlTree.inOrder(avlTree.root);
     //   avlTree.preOrder(avlTree.root);


//
//                    5
//                /      \
//               3       7
//             /  \     /  \
//            2   4    6   8

        //    binarySearchTree.deleteNode(5);

        //    binarySearchTree.delete(7);
        //  binarySearchTree.inOrder(binarySearchTree.root);

        //   System.out.println("Height: " + binarySearchTree.findHeight(binarySearchTree.root));
        //     System.out.println(binarySearchTree.findAncestor(6).data);


        //    System.out.println(binarySearchTree.leftMost(binarySearchTree.root.right));
    }
}
