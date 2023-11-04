public class Main {

    public static void main(String[] args) {
//        /**
//         *                          80
//         *                  /               \
//         *              40                  120
//         *           /      \            /        \
//         *         20        60         100       140 
//         *       /   \     /   \      /    \    /    \
//         *     10    30   50   70    90   110  130   150
//         */
        BSTree myTree = new BSTree();
        myTree.insert("080", "name1", 5);
        myTree.insert("040", "name1", 5);
        myTree.insert("120", "name1", 5);
        myTree.insert("020", "name1", 5);
        myTree.insert("060", "name1", 5);
        myTree.insert("100", "name1", 5);
        myTree.insert("140", "name1", 5);
        myTree.insert("010", "name1", 5);
        myTree.insert("030", "name1", 5);
        myTree.insert("050", "name1", 5);
        myTree.insert("070", "name1", 5);
        myTree.insert("090", "name1", 5);
        myTree.insert("110", "name1", 5);
        myTree.insert("130", "name1", 5);
        myTree.insert("150", "name1", 5);
        myTree.insert("033", "name1", 5);
        myTree.insert("025", "name1", 5);

        System.out.println(myTree.heightOfTree());
        System.out.println(myTree.size());
        Node p = myTree.search("020");
        Node f = myTree.father(p);
        System.out.println((f == null) ? "p is root, no farent" : f.info);
        myTree.rotateLeft(p);
        //myTree.deleteByCopying("12");
        //myTree.deleteByMerging("12");
        myTree.preOrder();
        myTree.preOrderTraversal();
        myTree.inOrder();
        myTree.inOrderTraversal();
        myTree.postOrder();
        myTree.postOrderTraversal();
        myTree.breadthFirst();
        Student[] arr = myTree.toArray();
        for (Student s : arr) {
            System.out.print(s.id + " ");
        }
    }

}
