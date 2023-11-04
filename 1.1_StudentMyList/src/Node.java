
public class Node {

    Student info;
    Node next;

    public Node(Student s, Node p) {
        info = s;
        next = p;
    }

    public Node(Student info) {
        this.info = info;
        this.next = null;
    }

}
