import java.util.Deque;

public class RedBlackTree<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;     // root of the BST

    // BST helper node data type
    private class Node {
        private Key key;           // key
        private Value val;         // associated data
        private Node left, right;  // links to left and right subtrees
        private boolean color;     // color of parent link
        private int size;          // subtree count

        public Node(Key key, Value val, boolean color, int size) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.size = size;
        }
    }

    public RedBlackTree() {
    }

    // is node x red; false if x is null ?
    private boolean isRed(Node x) {
        return false;
    }

    // number of node in subtree rooted at x; 0 if x is null
    private int size(Node x) {
        return 0;
    }


    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return 0;
    }

    /**
     * Is this symbol table empty?
     *
     * @return {@code true} if this symbol table is empty and {@code false} otherwise
     */
    public boolean isEmpty() {
        return false;
    }

    public Value get(Key key) {
        return null;
    }

    // value associated with the given key in subtree rooted at x; null if no such key
    private Value get(Node x, Key key) {
        return null;
    }

    public boolean contains(Key key) {
        return false;
    }

    public void put(Key key, Value val) {

    }

    // insert the key-value pair in the subtree rooted at h
    private Node put(Node h, Key key, Value val) {
        return null;
    }

    public void deleteMin() {
    }

    // delete the key-value pair with the minimum key rooted at h
    private Node deleteMin(Node h) {
        return null;
    }

    public void deleteMax() {
    }

    // delete the key-value pair with the maximum key rooted at h
    private Node deleteMax(Node h) {
        return null;
    }

    public void delete(Key key) {
    }

    // delete the key-value pair with the given key rooted at h
    private Node delete(Node h, Key key) {
        return null;
    }

    private Node rotateRight(Node h) {
        return null;
    }

    // make a right-leaning link lean to the left
    private Node rotateLeft(Node h) {
        return null;
    }

    // flip the colors of a node and its two children
    private void flipColors(Node h) {

    }

    // Assuming that h is red and both h.left and h.left.left
    // are black, make h.left or one of its children red.
    private Node moveRedLeft(Node h) {
        return null;
    }

    // Assuming that h is red and both h.right and h.right.left
    // are black, make h.right or one of its children red.
    private Node moveRedRight(Node h) {
        return null;
    }

    // restore red-black tree invariant
    private Node balance(Node h) {
        return null;
    }

    public int height() {
        return 0;
    }

    private int height(Node x) {
        return 0;
    }

    public Key min() {
        return null;
    }

    // the smallest key in subtree rooted at x; null if no such key
    private Node min(Node x) {
        return null;
    }

    public Key max() {
        return null;
    }

    // the largest key in the subtree rooted at x; null if no such key
    private Node max(Node x) {
        return null;
    }

    public Key floor(Key key) {
        return null;
    }

    // the largest key in the subtree rooted at x less than or equal to the given key
    private Node floor(Node x, Key key) {
        return null;
    }

    public Key ceiling(Key key) {
        return null;
    }

    // the smallest key in the subtree rooted at x greater than or equal to the given key
    private Node ceiling(Node x, Key key) {
        return null;
    }

    public Key select(int rank) {
        return null;
    }

    // Return key in BST rooted at x of given rank.
    // Precondition: rank is in legal range.
    private Key select(Node x, int rank) {
        return null;
    }

    public int rank(Key key) {
        return 0;
    }

    // number of keys less than key in the subtree rooted at x
    private int rank(Key key, Node x) {
        return 0;
    }

    public Iterable<Key> keys() {
        return null;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    // add the keys between lo and hi in the subtree rooted at x
    // to the queue
    private void keys(Node x, Deque<Key> queue, Key lo, Key hi) {
    }

    public int size(Key lo, Key hi) {
        return 0;
    }

    private boolean check() {
        return false;
    }

    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict
    private boolean isBST() {
        return false;
    }

    // is the tree rooted at x a BST with all keys strictly between min and max
    // (if min or max is null, treat as empty constraint)
    private boolean isBST(Node x, Key min, Key max) {
        return false;
    }

    // are the size fields correct?
    private boolean isSizeConsistent() {
        return false;
    }

    private boolean isSizeConsistent(Node x) {
        return false;
    }

    // check that ranks are consistent
    private boolean isRankConsistent() {
        return false;
    }

    // Does the tree have no red right links, and at most one (left)
    // red links in a row on any path?
    private boolean isTwoThree() {
        return false;
    }

    private boolean isTwoThree(Node x) {
        return false;
    }

    // do all paths from root to leaf have same number of black edges?
    private boolean isBalanced() {
        return false;
    }

    // does every path from the root to a leaf have the given number of black links?
    private boolean isBalanced(Node x, int black) {
        return false;
    }
}