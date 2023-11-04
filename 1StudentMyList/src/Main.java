
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        StudentGroup stds=new StudentGroup(50);
//
//        String[] name= {"A", "B","C","D"};
//        double[] gpa= {1,2,3,4};
//        
//        for(int i=0;i<name.length;i++){
//            stds.add(new Student(name[i], gpa[i]));
//        }
//        
//        stds.deleteAtIndex(2);
//        stds.addAtIndex(new Student("hello 100", 7), 2);
//        stds.display();
        MyList stds = new MyList();
        stds.addLast("Hello4", 5);
        stds.addLast("Hello1", 2);
        stds.addLast("Hello4", 3);
        stds.addLast("Hello2", 4);
        stds.addLast("Hello0", 5);
//          //stds.traverse();
//         stds.addFirst(new Student("Hello0", 7));
//          Node p=stds.search(new Student("Hello4", 5));
//          stds.addAfter(p, new Student("Hello7", 7));
//          stds.addBefore(p, new Student("before", 7410));
        stds.traverse();
        
        System.out.println(stds.sorted());
        stds.insertionSort();
        System.out.println(stds.sorted());
        System.out.println("sort------------------");
        Node p = stds.get(4);
        // stds.delete(p);
        stds.insert(new Student("Hello3", 5));
        stds.traverse();
        System.out.println("reverse");
        stds.reverse(2, 5);
        stds.traverse();
    }
}
