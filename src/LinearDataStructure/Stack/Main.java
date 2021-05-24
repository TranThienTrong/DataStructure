package LinearDataStructure.Stack;

public class Button.Main {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);

//        arrayStack.push(1);
//        arrayStack.push(3);
//        arrayStack.push(5);
//        arrayStack.push(2);
//        arrayStack.push(4);
//
//        arrayStack.pop();
//        arrayStack.peek();
//        arrayStack.traversal();

        ListStack<Integer> listStack = new ListStack<>();
        listStack.push(1);
        listStack.push(3);
        listStack.push(5);
        listStack.push(2);

        listStack.pop();
        listStack.traversal();
        System.out.println(listStack.peek());

    }
}
