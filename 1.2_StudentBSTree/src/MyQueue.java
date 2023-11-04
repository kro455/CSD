public class MyQueue<T> {

    private class Node {

        T info;
        Node next;

        public Node(T o, Node p) {
            info = o;
            next = p;
        }

        public Node(T info) {
            this.info = info;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    public MyQueue() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = tail = null;
    }

    /**
     * insert a node with value x at the end of the queue.
     *
     * @param o add obj
     */
    public void enqueue(T o) {
        Node newNode = new Node(o);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
     * remove the first element on the queue and return it's value; throw
     * Exception for empty queue.
     *
     * @return obj t
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new NullPointerException("empty queue");
        }
        T t = head.info;
        if (head.next == null) {
            clear();
        } else {
            head = head.next;
        }
        return t;
    }

    /**
     * return value of the first node of the queue; throw Exception for empty
     * queue.
     *
     * @return value of the first node of the queue
     */
    public T first() {
        if (isEmpty()) {
            throw new NullPointerException("empty queue");
        }
        return head.info;
    }

    //display all values in the queue from the front to the rear.
    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.println(p.info);
            p = p.next;
        }
        //System.out.println();
    }
}
