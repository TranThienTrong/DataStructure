package UnLinear.Tree;

public class BinarySearchTree<T> {
    Node<T> root;

    public BinarySearchTree(T data) {
        this.root = new Node<>(data);
    }

    public BinarySearchTree() {
        this.root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }


    public void inOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data + " ");
        inOrder(node.right);
    }


    public int getHeight(Node<T> node) {
        if (node == null) {
            return 0;
        }

        int leftSubtree = getHeight(node.left);
        int rightSubtree = getHeight(node.right);

        if (leftSubtree > rightSubtree) {
            return leftSubtree + 1;
        } else {
            return rightSubtree + 1;
        }
    }

    public int findHeight(Node<T> node) {
        if (node == null){
            return 0;
        }
        return 1 + Math.max(findHeight(node.left), findHeight(node.right));
    }



    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> parentOfNewNode = null; // Đây là node cha của Node đang xét

        Node<T> current = this.root;

        if (root == null) {
            root = newNode;
            return;
        }

        while (current != null) { // Tìm vị trí sẽ đặt của Node, prev là parent của Node đó
            parentOfNewNode = current;

            if (newNode.compareTo(current) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (newNode.compareTo(parentOfNewNode) < 0) {
            parentOfNewNode.left = newNode;
        } else {
            parentOfNewNode.right = newNode;
        }
    }

    public void insertRec(T data) {
        root = insertRecursion(root, data); // Lấy Root làm trung tâm, từ đó:
        // root.left
        // root.right.right
        // root.left.left.right
        // ...
    }

    public Node<T> insertRecursion(Node<T> parent, T data) { //

        Node<T> newNode = new Node<>(data);
        if (parent == null) {
            return newNode;
        }

        if (parent.compareTo(newNode) > 0) {
            parent.left = insertRecursion(parent.left, data);
        } else if (parent.compareTo(newNode) < 0) {
            parent.right = insertRecursion(parent.right, data);
        }


        return parent;
    }


    public void deleteRec(T data) {
        root = deleteRecursion(root, data);
    }

    private Node<T> deleteRecursion(Node<T> parent, T data) {
        Node<T> deletedNode = new Node<>(data);

        if (parent == null) {
            return parent;
        }
        if (parent.compareTo(deletedNode) > 0) {
            parent.left = deleteRecursion(parent.left, data);
        } else if (parent.compareTo(deletedNode) < 0) {
            parent.right = deleteRecursion(parent.right, data);
        } else { // Data = parent.data    => Node to be deleted

            /* Case 1 */

            if (parent.left == null && parent.right == null) {
                return null;
            }

            /* Case 2 */
            if (parent.left == null) {
                return parent.right;
            } else if (parent.right == null) {
                return parent.left;
            }


            /* Case 3 */

            if (parent.left != null && parent.right != null) {
                parent.data = leftMost(parent.right).data;
                // Delete the successor
                parent.right = deleteRecursion(parent.right, parent.data);
            }

        }

        return parent;

    }

    public Node<T> leftMost(Node<T> node) {
        if (node.left == null && node.right == null) {
            return node;
        }
        return leftMost(node.left);
    }


    public Node<T> deleteNode(int value) {
        Node<T> parent = null, current = root;
        boolean hasLeft = false;

        if (root == null) {
            return root;
        }


        while (current != null) {
            if ((int) current.data == value) {
                break;
            }

            parent = current;
            if (value < (int) current.data) {
                hasLeft = true;
                current = current.left;
            } else {
                hasLeft = false;
                current = current.right;
            }
        }


        if (parent == null) {
            return deleteNodeIteratively(current);
        }

        if (hasLeft) {
            parent.left = deleteNodeIteratively(current);
        } else {
            parent.right = deleteNodeIteratively(current);
        }

        return root;
    }

    private Node<T> deleteNodeIteratively(Node<T> node) {

        if (node != null) {
            if (node.left == null && node.right == null) {
                return null;
            }

            if (node.left != null && node.right != null) {
                Node<T> inOrderSuccessor = deleteInOrderSuccessorDuplicate(node);
                node.data = inOrderSuccessor.data;


            } else if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return node;
    }

    private Node<T> deleteInOrderSuccessorDuplicate(Node<T> node) {
        Node<T> parent = node;
        node = node.right;
        boolean rightChild = node.left == null;

        while (node.left != null) {
            parent = node;
            node = node.left;
        }

        if (rightChild) {
            parent.right = node.right;
        } else {
            parent.left = node.right;
        }

        node.right = null;
        return node;
    }


    public void delete(int value) {
        Node<T> current = root;
        Node<T> leftMostNode = null;


        while (current != null) {
            if ((int) current.data == value) {
                leftMostNode = leftMost(current.right);
                break;
            } else {
                if (value < (int) current.data) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
        }

        Node<T> ancestor = findAncestor((int) leftMostNode.data);
        current.data = leftMostNode.data;
        if (ancestor == current) {
            ancestor.right = null; // Current chính là Ansestor vì chỉ có 1 Node bên Phải và Node đó là Leaf
        } else {
            ancestor.left = null;
        }


    }

    public Node<T> findAncestor(int value) {
        Node<T> parent = null;
        Node<T> current = root;

        if (root == null) {
            return null;
        }

        while (current != null) {

            if ((int) current.data == value) {
                break;
            } else {
                parent = current;
                if (value < (int) current.data) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }

        }

        System.out.println("Ancestor of " + value + " is: " + parent.data);
        return parent;
    }

}
