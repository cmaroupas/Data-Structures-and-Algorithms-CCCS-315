/* Student Name : Cynthia Maroupas Student ID: 261119382 Class: CCCS 315-784 */
import java.util.List;

public class Main {
    /**
     * The main method of the program. It creates a binary tree of Worker objects, prints the tree to the console,
     * and prints the pre-order traversal of the tree to the console.
     */
    public static void main(String[] args) {
        Worker worker1 = new Worker("Emily Campbell", 2500.00);
        Worker worker2 = new Worker("Liam Fraser", 200.00);
        Worker worker3 = new Worker("Eshaan Shah", 150.00);
        Worker worker4 = new Worker("Jasleen Kaur", 100.00);
        Worker worker5 = new Worker("Giselle Lacroix", 500.00);
        Worker worker6 = new Worker("Ethan Kim", 120.00);
        Worker worker7 = new Worker("Isabella Singh", 80.00);

        BinaryTREEADT tree = new BinaryTREEADT();
        tree.setRoot(worker1);
        tree.setLeft(worker1, worker2);
        tree.setRight(worker1, worker3);
        tree.setLeft(worker2, worker4);
        tree.setRight(worker2, worker5);
        tree.setLeft(worker3, worker6);
        tree.setRight(worker3, worker7);

        tree.printTree();

        List<String> preorderList = tree.preorderTraversal();
        System.out.println("Preorder traversal: " + preorderList);
    }
}