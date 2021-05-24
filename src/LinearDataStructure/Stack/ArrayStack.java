package LinearDataStructure.Stack;

public class ArrayStack {
    int top;
    int max;
    int[] arr;

    public ArrayStack(int max) {
        this.max = max;
        this.arr = new int[max];
        this.top = -1;
    }

    public ArrayStack() {
        this.max = 1000;
        this.top = -1;
        this.arr = new int[max];
    }

    public int size() {
        return top + 1;
    }

    public void push(int e) {
        if (top >= max) {
            System.out.println("Overflow");
        } else {
            this.arr[++top] = e; // Prefix làm cho Top tăng lên 1 ngay ở dòng này
            System.out.println(e + " Pushed");
        }
    }

    public int pop() {
        if (top < 0) {
            System.out.println("Empty");
            return -1;
        }
        return arr[--top];
    }

    public void peek(){
        if (top < 0) {
            System.out.println("Empty");
            return;
        }
        System.out.println("Peek: " + arr[top]);
    }


    public void traversal() {
        if (top < 0) {
            System.out.println("Empty");
            return;
        }

        for (int i = top; i >= 0; i--) {
            if (i == top) {
                System.out.println("|___ " + arr[i] + " ___| <-- TOP");
            } else {
                System.out.println("|___ " + arr[i] + " ___|");
            }
        }
    }


    public boolean isEmpty(){
        if (top < 0) {
            System.out.println("Empty");
            return true;
        }
        return false;
    }
}
