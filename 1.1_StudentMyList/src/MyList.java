
public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    public MyList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = tail = null;
    }

    public int size() {
        int k = 0;
        Node p = head;
        while (p != null) {
            k++;
            p = p.next;
        }
        return k;
    }

    //O(1)
    public void addFirst(Student s) {
        Node newNode = new Node(s);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addFirst(String name, double gpa) {
        addFirst(new Student(name, gpa));
    }

    //O(1)
    public void addLast(Student s) {
        Node newNode = new Node(s);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    //O(1)
    public void addLast(String name, double gpa) {
        addLast(new Student(name, gpa));
    }

    public Node search(Student x) {
        Node p = head;
        while (p != null) {
            if (p.info.equals(x)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    //tim node dau tien co info.name == name.
    public Node searchFristByName(String name) {
        Node p = head;
        while (p != null) {
            //  p.info.name == name
            if (p.info.name.equals(name)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    //tim node thu K co info.name == name. 
    public Node searchName(String name, int k) {
        Node p = head;
        int count = 0;
        while (p != null) {
            //  p.info.name == name
            if (p.info.name.equals(name)) {
                if (++count == k) {
                    return p;
                }
            }
            p = p.next;
        }
        return null;
    }

    //tim node cuoi cung co info.name == name. 
    public Node searchLastByName(String name) {
        Node p = head;
        Node last = null;
        while (p != null) {
            //  p.info.name == name
            if (p.info.name.equals(name)) {
                last = p;
            }
            p = p.next;
        }
        return last;
    }

    public Node searchFirstByGpa(double gpa) {
        Node p = head;
        while (p != null) {
            if (p.info.gpa == gpa) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    // find min gpa
    public Node min() {
        Node min = head;
        Node p = head;
        while (p != null) {
            if (min.info.gpa > p.info.gpa) {
                min = p;
            }
            p = p.next;
        }
        return min;
    }

    //tim min nho thu 2. 
    public double secondMinGpa() {
        double min1 = Double.MAX_VALUE;
        double min2 = Double.MAX_VALUE;
        Node p = head;
        while (p != null) {
            double x = p.info.gpa;
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x > min1 && x < min2) {
                min2 = x;
            }
            p = p.next;
        }
        return min2;
    }

    // Find the third min gpa
    public double findThirdMinGpa() {
        double min1 = Double.MAX_VALUE;
        double min2 = Double.MAX_VALUE;
        double min3 = Double.MAX_VALUE;
        Node p = head;
        while (p != null) {
            double x = p.info.gpa;
            if (x < min1) {
                min3 = min2;
                min2 = min1;
                min1 = x;
            } else if (x > min1 && x < min2) {
                min3 = min2;
                min2 = x;
            } else if (x > min2 && x < min3) {
                min3 = x;
            }
            p = p.next;
        }
        return min3;
    }

    // find max gpa
    public Node max() {
        Node max = head;
        Node p = head;
        while (p != null) {
            if (max.info.gpa < p.info.gpa) {
                max = p;
            }
            p = p.next;
        }
        return max;
    }

    //tim max lon thu 2. 
    public double secondMaxGpa() {
        double max1 = Double.MIN_VALUE;
        double max2 = Double.MIN_VALUE;
        Node p = head;
        while (p != null) {
            double x = p.info.gpa;
            if (x > max1) {
                max2 = max1;
                max1 = x;
            } else if (x < max1 && x > max2) {
                max2 = x;
            }
            p = p.next;
        }
        return max2;
    }

    // Find the third max gpa
    public double findThirdMaxGpa() {
        double max1 = Double.MIN_VALUE;
        double max2 = Double.MIN_VALUE;
        double max3 = Double.MIN_VALUE;
        Node p = head;
        while (p != null) {
            double x = p.info.gpa;
            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x < max1 && x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x < max2 && x > max3) {
                max3 = x;
            }
            p = p.next;
        }
        return max3;
    }

    /**
     * Display the first [number] students having gpa > [xGpa]
     *
     * @param number number of list
     * @param xGpa find gpa > xGpa
     */
    public void displayStudents(int number, double xGpa) {
        int count = 0;
        Node p = head;
        while (p != null) {
            if (p.info.gpa > xGpa) {
                System.out.println(p.info);
                if (++count == number) {
                    return;
                }
            }
            p = p.next;
        }
    }

    /**
     * Display the last [number] students having gpa > [xGpa]
     *
     * @param number number of list
     * @param xGpa find gpa > xGpa
     */
    public void displayLastStudents(int number, double xGpa) {
        MyQueue<Student> queue = new MyQueue<>();
        int count = 0;
        Node p = head;
        while (p != null) {
            if (p.info.gpa > xGpa) {
                count++;
                queue.enqueue(p.info);
                if (count > number) {
                    queue.dequeue();
                    count--;
                }
            }
            p = p.next;
        }
        queue.traverse();
    }

//    private Node before(Node x) {
//        if (x == head) {
//            return null;
//        }
//        Node before = head;
//        while (before.next != x) {
//            before = before.next;
//        }
//        return before;
//    }
    //O(1)
    public void addAfter(Node p, Student s) {
        if (p == null) {
            return;
        }
        Node newNode = new Node(s);
        newNode.next = p.next;
        p.next = newNode;
        if (p == tail) {
            tail = newNode;
        }
    }

    //O(n)
    public void addBefore(Node p, Student s) {
        if (isEmpty() || p == null) {
            return;
        }
        if (p == head) {
            addFirst(s);
            return;
        }
        Node f = head;
        while (f.next != p) {
            f = f.next;
        }
        addAfter(f, s);
    }

    //O(n)
    public void deleteBefore(Node p) {
        if (isEmpty() || p == null || p == head) {
            return;
        }
        Node before = head;
        while (before.next != p) {
            before = before.next;
        }
        delete(before);
    }

    //duyet lan luot cac phan tu(head -> tail)
    public void traverse() {
        Node p = head;
        while (p != null) {
            //-------------------------------
            System.out.println(p.info); // insert your code here
            //-------------------------------
            p = p.next;
        }
        //System.out.println();
    }

    //O(1)
    public void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    // O(n)
    public void deleteLast() {
        if (isEmpty()) {
            return;
        }
        if (head == tail) {
            clear();
            return;
        }
        Node beforeLast = head;
        while (beforeLast.next != tail) {
            beforeLast = beforeLast.next;
        }
        beforeLast.next = null;
        tail = beforeLast;
    }

    //delete after node p O(1)
    public void deleteAfter(Node p) {
        if (p == null || p.next == null) {
            return;
        }
        if (p.next == tail) {
            tail = p;
        }
        p.next = p.next.next;
    }

    /**
     * get Node with index
     *
     * @param index
     * @return Node in[head, tail]
     * @throws index out of list
     */
    public Node get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index must be >= 0");
        }
        int count = 0;
        Node p = head;
        while (p != null) {
            if (count++ == index) {
                return p;
            }
            p = p.next;
        }
        throw new IndexOutOfBoundsException("Index must be < " + count);
    }

    //O(n) xoa by index.
    public void delete(int i) {
        if (isEmpty()) {
            return;
        }
        if (i == 0) {
            deleteFirst();
        } else {
            Node before = get(i - 1);
            deleteAfter(before);
        }
    }

    public Student[] toArray() {
        Student[] arr = new Student[size()];
        int i = 0;
        for (Node p = head; p != null; p = p.next) {
            arr[i++] = new Student(p.info.name, p.info.gpa);
        }
        return arr;
    }

//    public void delete(Node p) {
//        if (isEmpty() || p == null) {
//            return;
//        }
//        if (p == head) {
//            deleteFirst();
//        }
//        Node before = head;
//        while (before.next != p) {
//            before = before.next;
//        }
//        deleteAfter(before);
//    }
    //xoa 1 node x dau tien. 
    public void delete(Node x) {
        Node f, p;
        f = null;
        p = head;
        while (p != null) {
            if (p == x) {
                break;
            }
            f = p;
            p = p.next;
        }
        if (p == null) {
            return;//x is not found
        }
        if (f == null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        f.next = p.next;
        if (f.next == null) {
            tail = f;
        }
    }

    //xoa mot Node dau tien co info = x
    public void delete(Student x) {
        if (isEmpty()) {
            return;
        }
        if (head.info.equals(x)) {
            deleteFirst();
            return;
        }
        Node p = head;
        while (p.next != null) {
            if (p.next.info.equals(x)) {
                deleteAfter(p);
                return;
            }
            p = p.next;
        }
    }

    //xoa tat ca student co ten = name can xoa. 
    public void deleteAllByName(String name) {
        while (head != null && head.info.name.equals(name)) {
            deleteFirst();
        }
        if (head == null) {
            return;
        }
        Node p = head;
        while (p.next != null) {
            if (p.next.info.name.equals(name)) {
                deleteAfter(p);
            } else {
                p = p.next;
            }
        }
    }

    // chen 1 phan tu vao list da duoc sap xep (ascendingly by name)
    public void insert(Student s) {
        // if s < head then add first
        if (isEmpty() || head.info.name.compareTo(s.name) > 0) {
            addFirst(s);
            return;
        }
        //if tail <= s then add last
        if (tail.info.name.compareTo(s.name) <= 0) {
            addLast(s);
            return;
        }
        // else, s will be this case: head <= s < tail, and head != null
        Node p = head;
        while (p.next != null) {
            // if p <= s < p.next then add s after p
            if (p.next.info.name.compareTo(s.name) > 0) {
                addAfter(p, s);
                return;
            }
            p = p.next;
        }
    }

    //sort by name
    public void insertionSort() {
        MyList newList = new MyList();
        Node p = head;
        while (p != null) {
            newList.insert(p.info);
            p = p.next;
        }
        head = newList.head;
        tail = newList.tail;
    }

    // merge: tron 1 list khac da sap xep vao list hien tai. (ascendingly by name)
    public void merge(MyList otherList) {
        MyList mergedList = new MyList();
        Node p1 = this.head;
        Node p2 = otherList.head;
        while (p1 != null && p2 != null) {
            //if p1 < p2
            if (p1.info.name.compareTo(p2.info.name) < 0) {
                //add p1 to mergedList and p1=p1.next
                mergedList.addLast(p1.info);
                p1 = p1.next;
            } else {
                //if p2 >= p1. add p2 and p2=p2.next
                mergedList.addLast(p2.info);
                p2 = p2.next;
            }
        }
        //if p1 not null
        while (p1 != null) {
            mergedList.addLast(p1.info);
            p1 = p1.next;
        }
        // if p2 not null
        while (p2 != null) {
            mergedList.addLast(p2.info);
            p2 = p2.next;
        }
        this.head = mergedList.head;
        this.tail = mergedList.tail;
    }

    public void mergeSort() {
        //where am i ? 
    }

    // swap info between Node x and Node y
    public void swap(Node x, Node y) {
        Student temp = x.info;
        x.info = y.info;
        y.info = temp;
    }

    //sap xep lua chon, khuyen ko nen dung. (ascendingly by name)
    public void selectionSort() {
        for (Node i = head; i != null; i = i.next) {
            Node min = i;
            for (Node j = i.next; j != null; j = j.next) {
                if (min.info.name.compareTo(j.info.name) > 0) {
                    min = j;
                }
            }
            swap(i, min);
        }
    }

    //10. sort the linked list ascendingly by name
    public void sort(int startIndex, int endIndex) {
        // p and q will be in [head, tail]
        Node p = get(startIndex);
        Node q = get(endIndex);
        bubbleSort(p, q);
    }

    // sort ascendingly by name
    public void bubbleSort(Node start, Node end) {
        boolean swapped;
        Node last = (end == null) ? null : end.next;
        Node p;
        do {
            p = start;
            swapped = false;
            while (p.next != last) {
                if (p.info.name.compareTo(p.next.info.name) > 0) {
                    swap(p, p.next);
                    swapped = true;
                }
                p = p.next;
            }
            last = p;
        } while (swapped);
    }

    // check sort by info by name(ascendingly)
    public boolean sorted() {
        Node p = head;
        while (p != null) {
            if (p.next != null) {
                if (p.info.name.compareTo(p.next.info.name) > 0) {
                    return false;
                }
            }
            p = p.next;
        }
        return true;
    }

    //5. sort descendingly by gpa use bubble sort
    public void sortDescByGpa() {
        boolean swapped;
        Node last = null;
        Node p;
        do {
            p = head;
            swapped = false;
            while (p.next != last) {
                if (p.info.gpa < p.next.info.gpa) {
                    swap(p, p.next);
                    swapped = true;
                }
                p = p.next;
            }
            last = p;
        } while (swapped);
    }

    //dao nguoc list
    public void reverse() {
        MyList newList = new MyList();
        Node p = head;
        while (p != tail.next) {
            newList.addFirst(p.info);
            p = p.next;
        }
        head = newList.head;
        tail = newList.tail;
    }

    //dao nguoc list tu left to right (index)
    public void reverse(int left, int right) {
        if (left >= right || left < 0 || right >= size()) {
            return;
        }
        Node last = get(right);
        MyList newList;
        if (left == 0) {
            newList = new MyList(head, last);
            newList.reverse();
            head = newList.head;
        } else {
            Node beforeFirst = get(left - 1);
            newList = new MyList(beforeFirst.next, last);
            newList.reverse();
            beforeFirst.next = newList.head;
        }
        newList.tail.next = last.next;
    }
}
