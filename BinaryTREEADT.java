/* Student Name : Cynthia Maroupas Student ID: 261119382 Class: CCCS 315-784 */

import java.util.ArrayList;
import java.util.List;
/**
 * This class represents a binary tree data structure that holds a hierarchical tree of Worker objects.
 * The class provides methods to manipulate and traverse the tree.
 */
public class BinaryTREEADT {
    private TreeNode root;
    private int size;

    /**
     * Constructs an empty binary tree.
     */
    public BinaryTREEADT() {
        root = null;
        size = 0;
    }

    /**
     * Returns the root Worker object of the tree.
     *
     * @return the root Worker object of the tree, or null if the tree is empty.
     */
    public Worker root() {
        if (root == null) {
            return null;
        }
        return root.worker;
    }

    /**
     * Sets the root of the tree to a given Worker object.
     *
     * @param a the Worker object to set as the root of the tree.
     */
    public void setRoot(Worker a) {
        root = new TreeNode(a, null);
        size++;
    }

    /**
     * Returns the parent of a given Worker object in the tree.
     *
     * @param p the Worker object to find the parent of.
     * @return the parent of the given Worker object, or null if the given Worker object is the root of the tree or is not found in the tree.
     */
    public Worker parent(Worker p) {
        TreeNode node = findNode(root, p);
        if (node == null || node.parent == null) {
            return null;
        }
        return node.parent.worker;
    }

    /**
     * Returns the left child of a given Worker object in the tree.
     *
     * @param p the Worker object to find the left child of.
     * @return the left child of the given Worker object, or null if the given Worker object has no left child or is not found in the tree.
     */
    public Worker left(Worker p) {
        TreeNode node = findNode(root, p);
        if (node == null || node.left == null) {
            return null;
        }
        return node.left.worker;
    }

    /**
     * Returns the right child of a given Worker object in the tree.
     *
     * @param p the Worker object to find the right child of.
     * @return the right child of the given Worker object, or null if the given Worker object has no right child or is not found in the tree.
     */
    public Worker right(Worker p) {
        TreeNode node = findNode(root, p);
        if (node == null || node.right == null) {
            return null;
        }
        return node.right.worker;
    }

    /**
     * Sets the left child of a given Worker object in the tree to a given Worker object.
     *
     * @param p the Worker object to set the left child of.
     * @param a the Worker object to set as the left child of the given Worker object.
     * @return the Worker object that was set as the left child of the given Worker object, or null if the given Worker object is not found in the tree.
     */
    public Worker setLeft(Worker p, Worker a) {
        TreeNode node = findNode(root, p);
        if (node == null) {
            return null;
        }
        TreeNode child = new TreeNode(a, node);
        node.left = child;
        size++;
        return a;
    }

    /**
     * Sets the right child of a given Worker object in the tree to a given Worker object.
     *
     * @param p the Worker object to set the right child of.
     * @param a the Worker object to set as the right child of the given Worker object.
     * @return the Worker object that was set as the right child of the given Worker object, or null if the given Worker object is not found in the tree.
     */
    public Worker setRight(Worker p, Worker a) {
        TreeNode node = findNode(root, p);
        if (node == null) {
            return null;
        }
        TreeNode child = new TreeNode(a, node);
        node.right = child;
        size++;
        return a;
    }

    /**
     * Returns the number of Worker objects in the tree.
     *
     * @return the number of Worker objects in the tree.
     */
    public int size() {
        return size;
    }

    /**
     * Prints a representation of the tree to the console (as simple as possible).
     */
    public void printTree() {
        System.out.println();
    }

    /**
     * Returns a List of Worker objects representing the pre-order traversal of the tree.
     *
     * @return a List of Worker objects representing the pre-order traversal of the tree.
     */
    public List<String> preorderTraversal() {
        List<String> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    /**
     * Performs a pre-order traversal of the binary tree, starting at a given TreeNode object.
     * Adds the string representation of each visited Worker object to the given List object in the order they are visited.
     *
     * @param node the TreeNode object to start the traversal from.
     * @param list the List object to add the string representations of visited Worker objects to.
     */

    private void preorder(TreeNode node, List<String> list) {
        if (node != null) {
            list.add("Worker Name: " + node.worker.getName() + ", Salary: $" + node.worker.getSalary());
            preorder(node.left, list);
            preorder(node.right, list);
        }
    }

    /**
     * Finds the node containing a given Worker object in the binary tree, starting at a given TreeNode object.
     *
     * @param node   the TreeNode object to start the search from.
     * @param worker the Worker object to search for.
     * @return the TreeNode object containing the given Worker object, or null if the given Worker object is not found in the tree.
     */
    private TreeNode findNode(TreeNode node, Worker worker) {
        if (node == null) {
            return null;
        }
        if (node.worker.equals(worker)) {
            return node;
        }
        TreeNode foundNode = findNode(node.left, worker);
        if (foundNode == null) {
            foundNode = findNode(node.right, worker);
        }
        return foundNode;
    }

    /**
     * This is a node class in a binary tree data structure that stores workers.
     * Each node contains a reference to a Worker object and pointers to its left and right child nodes.
     * The parent field stores a reference to the node's parent, allowing for traversal of the tree in both directions.
     */
    private static class TreeNode {
        Worker worker;
        TreeNode parent;
        TreeNode left;
        TreeNode right;

        /**
         * Constructs a TreeNode object with a given Worker object and parent TreeNode object.
         *
         * @param worker the Worker object to be stored in the node.
         * @param parent the parent TreeNode object of the node.
         */
        public TreeNode(Worker worker, TreeNode parent) {
            this.worker = worker;
            this.parent = parent;
            this.left = null;
            this.right = null;
        }
    }
}




