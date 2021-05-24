package LinearDataStructure.Stack;

public class ListStack<T> {
    Node<T> topNode;

    public ListStack(Node<T> topNode) {
        this.topNode = topNode;
    }

    public ListStack() {
        this.topNode = null;
    }

    public void push(T data) {
        Node<T> node = new Node<>(data);

        if (topNode == null) {
            topNode = node;
        } else {
            Node<T> temp = topNode;
            topNode = node;
            node.next = temp;
        }

        System.out.println(node + " Pushed");
    }

    public void pop() {
        if (topNode == null) {
            System.out.println("Empty");
            return;
        }

        topNode = topNode.next;
    }

    public Node<T> peek(){
        return topNode;
    }

    public void traversal() {
        Node<T> current = topNode;
        while (current != null) {
            if (current.data == topNode.data){
                System.out.println("|___ "+current.data+" ___| <-- TOP");
            }else {
                System.out.println("|___ "+current.data+" ___|");
            }

            current = current.next;
        }
    }


}
