package UnLinear.Tree;

public class BinaryTree<T> {
    TNode<T> root;

    public BinaryTree(T data) {
        this.root = new Node<>(data);
    }

    public BinaryTree() {
        this.root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }


    public void inOrder(Node<T> node){
        if (node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.data + " ");
        inOrder(node.right);
    }
}
