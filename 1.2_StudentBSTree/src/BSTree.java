
public class BSTree {

    Node root;

    public BSTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public void visit(Node p) {
        if (p != null) {
            System.out.print(p.info.id + " ");
        }
    }

    //tim kiem Node chua id bat dau tu root.
    public Node search(String id) {
        return search(root, id);
    }

    // tim kiem id bat dau bang node p. 
    public Node search(Node p, String id) {
        while (p != null) {
            //  p.info.id == id
            if (p.info.id.equals(id)) {
                return p;
            }
            //  p.info.id > id
            if (p.info.id.compareTo(id) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    //chen 1 Obj x vao tree theo id (key)
    //neu key la String dung compareTo. 
    //neu key la number dung toan tu == , > , <
    public void insert(Student x) {
        Node f = null;
        Node p = root;
        while (p != null) {
            //  p.info.id == x.id 
            if (p.info.id.equals(x.id)) {
                //System.out.println(" The key " + x.id + " already exists, no insertion");
                return;
            }
            f = p;
            //  p.info.id > x.id
            if (p.info.id.compareTo(x.id) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (f == null) {
            root = new Node(x);
            return;
        }
        //  f.info.id > x.id
        if (f.info.id.compareTo(x.id) > 0) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }

    public void insert(String id, String name, double gpa) {
        insert(new Student(id, name, gpa));
    }

    public int size() {
        return size(root);
    }

    public int size(Node p) {
        if (p == null) {
            return 0;
        }
        return size(p.left) + size(p.right) + 1;
    }

    public void preOrder() {
        System.out.println("pre order");
        preOrder(root);
        System.out.println();
    }

    public void preOrder(Node p) {
        if (p != null) {
            visit(p);
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    public void preOrderTraversal() {
        System.out.println("pre order Traversal");
        preOrderTraversal(root);
        System.out.println();
    }

    public void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        MyStack<Node> stack = new MyStack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node p = stack.pop();
            // insert code here
            System.out.print(p.info.id + " ");
            // ---------------------
            if (p.right != null) {
                stack.push(p.right);
            }

            if (p.left != null) {
                stack.push(p.left);
            }
        }
    }

    public void inOrderTraversal() {
        System.out.println("in Order Traversal");
        inOrderTraversal(root);
        System.out.println();
    }

    public void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        MyStack<Node> stack = new MyStack<>();
        Node p = root;

        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            p = stack.pop();
            // insert code here
            System.out.print(p.info.id + " ");
            //-----------------------
            p = p.right;
        }
    }

    public void postOrderTraversal() {
        System.out.println("post Order Traversal");
        postOrderTraversal(root);
        System.out.println();
    }

    public void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        MyStack<Node> stack1 = new MyStack<>();
        MyStack<Node> stack2 = new MyStack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            Node p = stack1.pop();
            stack2.push(p);

            if (p.left != null) {
                stack1.push(p.left);
            }

            if (p.right != null) {
                stack1.push(p.right);
            }
        }

        while (!stack2.isEmpty()) {
            // insert code here
            System.out.print(stack2.pop().info.id + " ");
            //---------------------
        }
    }

    private void balance(Student data[], int first, int last) {
        if (first <= last) {
            int middle = (first + last) / 2;
            insert(data[middle]);
            balance(data, first, middle - 1);
            balance(data, middle + 1, last);
        }
    }

    public void balance() {
        Student[] data = toArray();
        clear();
        balance(data, 0, data.length - 1);
    }

    public Student[] toArray() {
        MyStack<Node> stack = new MyStack<>();
        Node p = root;
        Student arr[] = new Student[size()];
        int count = 0;
        while ((!stack.isEmpty()) || (p != null)) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            arr[count++] = p.info;
            p = p.right;
        }
        return arr;
    }

    public void inOrder() {
        System.out.println("in order");
        inOrder(root);
        System.out.println();
    }

    public void inOrder(Node p) {
        if (p != null) {
            inOrder(p.left);
            visit(p);
            inOrder(p.right);
        }
    }

    public void postOrder() {
        System.out.println("post order");
        postOrder(root);
        System.out.println();
    }

    public void postOrder(Node p) {
        if (p != null) {
            postOrder(p.left);
            postOrder(p.right);
            visit(p);
        }
    }

    public void breadthFirst() {
        System.out.println("breadth First");
        breadthFirst(root);
        System.out.println();
    }

    public void breadthFirst(Node root) {
        if (root == null) {
            return;
        }
        MyQueue<Node> queue = new MyQueue<>();
        queue.enqueue(root);
        Node p;
        while (!queue.isEmpty()) {
            p = queue.dequeue();
            // insert code here
            visit(p);
            //----------------
            if (p.left != null) {
                queue.enqueue(p.left);
            }
            if (p.right != null) {
                queue.enqueue(p.right);
            }
        }
    }

    public int heightOfTree() {
        return height(root);
    }

    public int height(Node p) {
        if (p == null) {
            return 0;
        }
        return max(height(p.left), height(p.right)) + 1;
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    //depth
    //id la "key"
    //neu (key) la String dung compareTo. 
    //neu (key) la number dung toan tu == , > , <
    public int level(Node q) {
        int count = 0;
        Node p = root;
        while (p != null) {
            count++;
            //  p.info.id == q.info.id
            if (p.info.id.equals(q.info.id)) {
                return count;
            }
            //  p.info.id > q.info.id
            if (p.info.id.compareTo(q.info.id) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return -1;
    }

    public int balanceFactor(Node p) {
        if (p == null) {
            return 0;
        }
        return height(p.right) - height(p.left);
    }

    public boolean isBalanced(Node p) {
        return Math.abs(balanceFactor(p)) <= 1;
    }

    public boolean isAVL() {
        return isAVL(root);
    }

    public boolean isAVL(Node p) {
        if (p == null) {
            return true;
        }
        return isBalanced(p) && isAVL(p.left) && isAVL(p.right);
    }

    public int degree(Node p) {
        int count = 0;
        if (p.left != null) {
            count++;
        }
        if (p.right != null) {
            count++;
        }
        return count;
    }

    //id la "key"
    //neu (key) la String dung compareTo. 
    //neu (key) la number dung toan tu == , > , <
    public int deleteByMerging(String id) {
        Node f = null;
        Node p = root;
        while (p != null) {
            //  p.info.id == id
            if (p.info.id.equals(id)) {
                break;
            }
            f = p;
            //  p.info.id > id
            if (p.info.id.compareTo(id) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        //ko tim thay.
        if (p == null) {
            return 0;
        }
        //p is a leaf node
        if (p.left == null && p.right == null) {
            if (f == null) {
                clear();
            } else if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
            return 1;
        }
        // p has only left child
        if (p.left != null && p.right == null) {
            if (f == null) {
                root = root.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
            return 2;
        }
        // p has only right child
        if (p.left == null && p.right != null) {
            if (f == null) {
                root = root.right;
            } else if (f.left == p) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
            return 2;
        }
        // p has both left and right children
        Node rm = p.left;
        while (rm.right != null) {
            rm = rm.right;
        }
        rm.right = p.right;
        if (f == null) {
            root = p.left;
        } else if (f.left == p) {
            f.left = p.left;
        } else {
            f.right = p.left;
        }
        return 3;
    }

    //id la "key"
    //neu (key) la String dung compareTo. 
    //neu (key) la number dung toan tu == , > , <
    public int deleteByCopying(String id) {
        Node f = null;
        Node p = root;
        while (p != null) {
            //  p.info.id == id
            if (p.info.id.equals(id)) {
                break;
            }
            f = p;
            //  p.info.id > id
            if (p.info.id.compareTo(id) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        //ko tim thay.
        if (p == null) {
            return 0;
        }
        //p is a leaf node
        if (p.left == null && p.right == null) {
            if (f == null) {
                clear();
            } else if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
            return 1;
        }
        // p has only left child
        if (p.left != null && p.right == null) {
            if (f == null) {
                root = root.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
            return 2;
        }
        // p has only right child
        if (p.left == null && p.right != null) {
            if (f == null) {
                root = root.right;
            } else if (f.left == p) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
            return 2;
        }
        // p has both left and right children
        Node frm = null;
        Node rm = p.left;
        while (rm.right != null) {
            frm = rm;
            rm = rm.right;
        }
        p.info = rm.info;
        if (frm != null) {
            frm.right = rm.left;
        } else {
            p.left = rm.left;
        }
        return 3;
    }

    //id la "key"
    //neu (key) la String dung compareTo. 
    //neu (key) la number dung toan tu == , > , <
    public Node father(Node x) {
        if (x == null) {
            throw new NullPointerException();
        }
        Node p = root;
        Node f = null;
        while (p != null) {
            if (p == x) {
                return f;
            }
            f = p;
            //  p.info.id > x.info.id
            if (p.info.id.compareTo(x.info.id) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        throw new IndexOutOfBoundsException("Not found!");
    }

    //xoay node p sang phai.
    public void rotateRight(Node p) {
        if (p == null || p.left == null) {
            return;
        }
        Node a = p.left;
        p.left = a.right;
        a.right = p;
        Node f = father(p);
        if (f == null) {
            root = a;
        } else {
            if (f.left == p) {
                f.left = a;
            } else {
                f.right = a;
            }
        }
    }

    //xoay node p sang trai.
    public void rotateLeft(Node p) {
        if (p == null || p.right == null) {
            return;
        }
        Node a = p.right;
        p.right = a.left;
        a.left = p;
        Node f = father(p);
        if (f == null) {
            root = a;
        } else {
            if (f.left == p) {
                f.left = a;
            } else {
                f.right = a;
            }
        }
    }

    //////////// ko dung 2 ham nay. ////////////////////
    public Node rotateRight2(Node p) {
        if (p == null || p.left == null) {
            return (p);
        }
        Node a = p.left;
        p.left = a.right;
        a.right = p;
        return (a);
    }

    public Node rotateLeft2(Node p) {
        if (p == null || p.right == null) {
            return (p);
        }
        Node a = p.right;
        p.right = a.left;
        a.left = p;
        return (a);
    }

}
