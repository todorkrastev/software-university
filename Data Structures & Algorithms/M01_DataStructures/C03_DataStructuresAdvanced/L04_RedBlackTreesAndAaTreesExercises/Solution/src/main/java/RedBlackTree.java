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
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    // number of node in subtree rooted at x; 0 if x is null
    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }


    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size(this.root);
    }

    /**
     * Is this symbol table empty?
     *
     * @return {@code true} if this symbol table is empty and {@code false} otherwise
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        return get(this.root, key);
    }

    // value associated with the given key in subtree rooted at x; null if no such key
    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }

    public void put(Key key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException("argument to put() is null");
        }
        this.root = put(this.root, key, val);
        this.root.color = BLACK;
    }

    // insert the key-value pair in the subtree rooted at h
    private Node put(Node h, Key key, Value val) {
        if (h == null) {
            return new Node(key, val, RED, 1);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, val);
        } else if (cmp > 0) {
            h.right = put(h.right, key, val);
        } else {
            h.val = val;
        }

        // fix-up any right-leaning links
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.size = size(h.left) + size(h.right) + 1;

        return h;
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Tree is empty");
        }

        this.root = deleteMin(this.root);
    }

    // delete the key-value pair with the minimum key rooted at h
    private Node deleteMin(Node h) {
        if (h.left == null) {
            return null;
        }
        if (!isRed(h.left) && !isRed(h.left.left)) {
            h = moveRedLeft(h);
        }
        h.left = deleteMin(h.left);
        return balance(h);
    }

    public void deleteMax() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Tree is empty");
        }
        this.root = deleteMax(this.root);
    }

    // delete the key-value pair with the maximum key rooted at h
    private Node deleteMax(Node h) {
        if (isRed(h.left)) {
            h = rotateRight(h);
        }
        if (h.right == null) {
            return null;
        }
        if (!isRed(h.right) && !isRed(h.right.left)) {
            h = moveRedRight(h);
        }
        h.right = deleteMax(h.right);
        return balance(h);
    }

    public void delete(Key key) {
    }

    // delete the key-value pair with the given key rooted at h
    private Node delete(Node h, Key key) {
        return null;
    }

    private Node rotateRight(Node h) {
        Node temp = h.left;
        h.left = temp.right;
        temp.right = h;
        temp.color = h.color;
        h.color = RED;
        temp.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return temp;
    }

    // make a right-leaning link lean to the left
    private Node rotateLeft(Node h) {
        Node temp = h.right;
        h.right = temp.left;
        temp.left = h;
        temp.color = h.color;
        h.color = RED;
        temp.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return temp;
    }

    // flip the colors of a node and its two children
    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    // Assuming that h is red and both h.left and h.left.left
    // are black, make h.left or one of its children red.
    private Node moveRedLeft(Node h) {
        if (h == null) {
            return null;
        }
        if (isRed(h.left)) {
            h = rotateRight(h);
        }
        if (h.left == null || !isRed(h.left.left)) {
            return h;
        }
        h.left = rotateLeft(h.left);
        return rotateRight(h);
    }

    // Assuming that h is red and both h.right and h.right.left
    // are black, make h.right or one of its children red.
    private Node moveRedRight(Node h) {
        if (h == null) {
            return null;
        }
        if (isRed(h.right)) {
            h = rotateLeft(h);
        }
        if (h.right == null || !isRed(h.right.left)) {
            return h;
        }
        h.right = rotateRight(h.right);
        return rotateLeft(h);
    }

    // restore red-black tree invariant
    private Node balance(Node h) {
        if (h == null) {
            return null;
        }
        if (isRed(h.right)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.size = size(h.left) + size(h.right) + 1;

        return h;
    }

    public int height() {
        return height(this.root);
    }

    private int height(Node x) {
        if (x == null) {
            return -1;
        }
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public Key min() {
        Node min = min(this.root);
        return min != null ? min.key : null;
    }

    // the smallest key in subtree rooted at x; null if no such key
    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    public Key max() {
        Node max = max(this.root);
        return max != null ? max.key : null;
    }

    // the largest key in the subtree rooted at x; null if no such key
    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x.right);
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