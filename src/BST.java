import java.util.ArrayList;
import java.util.Iterator;

// -------------------------------------------------------------------------
/**
 * Implements an unbalanced binary search tree. Note that all "matching" is
 * based on the compareTo() method.
 *
 * 
 * @author <Xander Wolle> <xander1>
 * @version <9.30.19>
 * 
 * @param <T> any type
 */
public class BST<T extends Comparable<? super T>> implements Iterable<T> {

    // ~ Instance/static variables .............................................

    private BinaryNode<T> root;

    // ~ Constructor ...........................................................


    // ----------------------------------------------------------
    /**
     * Constructs an empty tree.
     */
    public BST() {
        root = null;
    }

    // ~ Public methods ........................................................


    // ----------------------------------------------------------
    /**
     * Insert into the tree.
     *
     * @param x
     *            the item to insert.
     */
    public void insert(T x) {
        root = insert(x, root);
    }


    // ----------------------------------------------------------
    /**
     * Remove the specified value from the tree.
     *
     * @param x
     *            the item to remove.
     */
    public void remove(T x) {
        root = remove(x, root);
    }


    // ----------------------------------------------------------
    /**
     * Find the smallest item in the tree.
     *
     * @return The smallest item, or null if the tree is empty.
     */
    public T findMin() {
        return elementAt(findMin(root));
    }


    // ----------------------------------------------------------
    /**
     * Find the largest item in the tree.
     *
     * @return The largest item in the tree, or null if the tree is empty.
     */
    public T findMax() {
        return elementAt(findMax(root));
    }


    // ----------------------------------------------------------
    /**
     * Find an item in the tree.
     *
     * @param x
     *            the item to search for.
     * @return the matching item or null if not found.
     */
    public T find(T x) {
        return elementAt(find(x, root));
    }


    // ----------------------------------------------------------
    /**
     * Make the tree logically empty.
     */
    public void makeEmpty() {
        root = null;
    }


    // ----------------------------------------------------------
    /**
     * Test if the tree is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }


    // ----------------------------------------------------------
    /**
     * Internal method to get element value stored in a tree node, with safe
     * handling of null nodes.
     *
     * @param node
     *            the node.
     * @return the element field or null if node is null.
     */
    private T elementAt(BinaryNode<T> node) {
        return (node == null) ? null : node.getElement();
    }


    // ----------------------------------------------------------
    /**
     * Internal method to insert a value into a subtree.
     *
     * @param x
     *            the item to insert.
     * @param node
     *            the node that roots the subtree.
     * @return the new root of the subtree.
     *         null if duplicate
     */
    private BinaryNode<T> insert(T x, BinaryNode<T> node) {
        if (node == null) {
            return new BinaryNode<T>(x);
        }
        else if (x.compareTo(node.getElement()) < 0) {
            node.setLeft(insert(x, node.getLeft()));
        }
        else if (x.compareTo(node.getElement()) > 0) {
            node.setRight(insert(x, node.getRight()));
        }
        else {
            throw new IllegalArgumentException("Duplicate Item");
        }
        return node;
    }


    // ----------------------------------------------------------
    /**
     * Internal method to remove a specified item from a subtree.
     *
     * @param x
     *            the item to remove.
     * @param node
     *            the node that roots the subtree.
     * @return the new root of the subtree.
     *         null if item cannot be found
     */
    private BinaryNode<T> remove(T x, BinaryNode<T> node) {
        // This local variable will contain the new root of the subtree,
        // if the root needs to change.
        BinaryNode<T> result = node;

        // If there's no more subtree to examine
        if (node == null) {
            throw new IllegalArgumentException("Item not found");
        }

        // if value should be to the left of the root
        if (x.compareTo(node.getElement()) < 0) {
            node.setLeft(remove(x, node.getLeft()));
        }
        // if value should be to the right of the root
        else if (x.compareTo(node.getElement()) > 0) {
            node.setRight(remove(x, node.getRight()));
        }
        // If value is on the current node
        else {
            // If there are two children
            if (node.getLeft() != null && node.getRight() != null) {
                BinaryNode<T> temp = findMax(node.getLeft());
                node.setElement(temp.getElement());
                node.setLeft(remove(temp.getElement(), temp));
            }
            // If there is only one child on the left
            else if (node.getLeft() != null) {
                result = node.getLeft();
            }
            // If there is only one child on the right
            else {
                result = node.getRight();
            }
        }
        return result;
    }


    // ----------------------------------------------------------
    /**
     * Internal method to find the smallest item in a subtree.
     *
     * @param node 
     *  the node that roots the tree.
     * @return node containing the smallest item.
     */
    private BinaryNode<T> findMin(BinaryNode<T> node) {
        if (node == null) {
            return node;
        }
        else if (node.getLeft() == null) {
            return node;
        }
        else {
            return findMin(node.getLeft());
        }
    }


    // ----------------------------------------------------------
    /**
     * Internal method to find the largest item in a subtree.
     *
     * @param node
     *            the node that roots the tree.
     * @return node containing the largest item.
     */
    private BinaryNode<T> findMax(BinaryNode<T> node) {
        if (node == null) {
            return node;
        }
        else if (node.getRight() == null) {
            return node;
        }
        else {
            return findMax(node.getRight());
        }
    }


    // ----------------------------------------------------------
    /**
     * Internal method to find an item in a subtree.
     *
     * @param x
     *            is item to search for.
     * @param node
     *            the node that roots the tree.
     * @return node containing the matched item.
     */
    private BinaryNode<T> find(T x, BinaryNode<T> node) {
        if (node == null) {
            return null; // Not found
        }
        else if (x.compareTo(node.getElement()) < 0) {
            // Search in the left subtree
            return find(x, node.getLeft());
        }
        else if (x.compareTo(node.getElement()) > 0) {
            // Search in the right subtree
            return find(x, node.getRight());
        }
        {
            return node; // Match
        }
    }


    /**
     * creates new iterator
     * 
     * @author xander
     * @return a new BST iterator
     */
    public Iterator<T> iterator() {

        return new BSTIterator();

    }


    /**
     * iterator class for BST
     * 
     * @author xander
     *
     * @param <A>
     *            type
     */
    private class BSTIterator implements Iterator<T> {

        //fields
        private ArrayList<BinaryNode> nodesSorted;
        private int index;


        /**
         * iterator constructor
         */
        public BSTIterator() {

            this.nodesSorted = new ArrayList<BinaryNode>();
            this.index = -1;
            this.inorder(root);

        }


        /**
         * do the inorder traversal
         * 
         * @param rootn
         *            the root node
         */
        private void inorder(BinaryNode rootn) {
           

            if (rootn == null) {

                return;

            }

            this.inorder(rootn.getLeft());
            this.nodesSorted.add(rootn);
            this.inorder(rootn.getRight());
        }


        /**
         * gets next node
         */
        public T next() {
            @SuppressWarnings("unchecked")
            T data = (T)this.nodesSorted.get(++index).getElement();
            return data;
        }


        /**
         * tests to see if next node is there
         */
        public boolean hasNext() {
            return this.index + 1 < this.nodesSorted.size();
        }
    }


    /**
     * Gets an in-order string representation of the tree
     * If the tree holds 5
     * / \
     * 2 6
     * \
     * 3
     * It would print (2, 3, 5, 6)
     * 
     * @return an in-order string representation of the tree
     */
    @Override
    public String toString() {
        if (root == null) {
            return "";
        }
        else {
            return root.toString();
        }
    }
}
