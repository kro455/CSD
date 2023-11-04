public class Node {

    Student info;
    Node left;
    Node right;

    public Node(Student info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public Node(Student info) {
        this(info, null, null);
    }

    public Node(String id, String name, double gpa) {
        this(new Student(id, name, gpa), null, null);
    }

    public Node(String id, String name, double gpa, Node left, Node right) {
        this(new Student(id, name, gpa), null, null);
        this.left = left;
        this.right = right;
    }
}
