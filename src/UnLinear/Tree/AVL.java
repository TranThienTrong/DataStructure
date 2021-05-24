package UnLinear.Tree;

public class AVL<T> {

    Node<T> root;

    // A utility function to get the height of the tree
    int height(Node<T> N) {
        if (N == null)
            return 0;

        return N.height;
    }

    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }


    Node<T> rightRotate(Node<T> oldRoot) {
        Node<T> newRoot = oldRoot.left;
        Node<T> rightOfNewRootBecomeLeftOfOldRoot = newRoot.right;

        // Perform rotation
        newRoot.right = oldRoot;
        oldRoot.left = rightOfNewRootBecomeLeftOfOldRoot;

        return newRoot;
    }


    Node<T> leftRotate(Node<T> oldRoot) {
        Node<T> newRoot = oldRoot.right;
        Node<T> leftOfNewRootBecomeRightOfOldRoot = newRoot.left;

        // Perform rotation
        newRoot.left = oldRoot;
        oldRoot.right = leftOfNewRootBecomeRightOfOldRoot;


        // Return new root
        return newRoot;
    }

    // Get Balance factor of node N
    int getBalance(Node<T> N) {
        if (N == null)
            return 0;

        return findHeight(N.left) - findHeight(N.right);
    }


    public int findHeight(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(findHeight(node.left), findHeight(node.right));
    }


    Node insert(Node<T> node, int key) {

        /* 1.  Perform the normal BST insertion */
        if (node == null) {
            return (new Node(key));
        }

        if (key < (int) node.data) {
            node.left = insert(node.left, key);
        } else if (key > (int) node.data) {
            node.right = insert(node.right, key);
        } else { // Duplicate keys not allowed
            return node;
        }


        /* Bước dưới đây sẽ được thực hiện sau khi xuất hiện node == null ở hàm trước và được trả về
           Lúc này node.left hay node.right đã có giá trị của node mới

            Bao nhiêu lần return về là bấy nhiêu lần method phải chạy xuống dưới này
        */


        int balance = getBalance(node);

        if (balance > 1) { // Bên trái nặng
            if (key < (int) node.left.data) { // Trái nặng do child bên trái
                return rightRotate(node);
            } else if (key > (int) node.left.data) { // Trái nặng do child bên
                node.left = leftRotate(node.left);
                return rightRotate(node); // Rotate như bth
            }

        }

        if (balance < -1) {
            if (key > (int) node.right.data) {
                return leftRotate(node);
            } else if (key < (int) node.right.data) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }



        /* return the (unchanged) node pointer */
        return node;
    }


    private Node<T> autoBalance(Node<T> oldRoot) {
        int balance = getBalance(oldRoot);

        if (balance > 1) { // Bên trái nặng hơn, cần Right Rotate

            if (findHeight(oldRoot.right.right) > findHeight(oldRoot.right.left)) {
                oldRoot = leftRotate(oldRoot);
            } else {
                oldRoot.right = rightRotate(oldRoot.right);
                oldRoot = leftRotate(oldRoot);
            }
        } else if (balance < -1) {
            if (findHeight(oldRoot.left.left) > findHeight(oldRoot.left.right)) {
                oldRoot = rightRotate(oldRoot);
            } else {
                oldRoot.left = leftRotate(oldRoot.left);
                oldRoot = rightRotate(oldRoot);
            }
        }
        return oldRoot;
    }


    void preOrder(Node<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }


    public void inOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data + " ");
        inOrder(node.right);
    }
}
