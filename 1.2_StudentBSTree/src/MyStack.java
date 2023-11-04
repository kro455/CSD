public class MyStack<T> {

    private class Node {

        T info;
        Node next;

        public Node(T s, Node p) {
            info = s;
            next = p;
        }

        public Node(T info) {
            this.info = info;
            this.next = null;
        }
    }

    Node head;

    public MyStack() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }

    public void push(T x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        T t = head.info;
        if (head.next == null) {
            clear();
        } else {
            head = head.next;
        }
        return t;
    }

    public T top() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        return head.info;
    }

    // display all values in the queue from the front to the rear.
    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.println(p.info);
            p = p.next;
        }
        // System.out.println();
    }

}
