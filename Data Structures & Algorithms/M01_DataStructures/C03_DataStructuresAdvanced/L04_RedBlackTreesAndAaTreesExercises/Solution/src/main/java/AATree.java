import java.util.function.Consumer;

class AATree<T extends Comparable<T>> {
    private Node<T> root;

    public static class Node<T> {
        T element;
        Node<T> right;
        Node<T> left;
        int level;

        Node(T element) {
            this.element = element;
            this.level = 1;
        }
    }

    public AATree() {
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public void insert(T element) {
        root = insert(root, element);
    }

    private Node<T> insert(Node<T> node, T element) {
        if (node == null) {
            node = new Node<>(element);
        }
        int cmp = element.compareTo(node.element);
        if (cmp < 0) {
            node.left = insert(node.left, element);
        } else if (cmp > 0) {
            node.right = insert(node.right, element);
        } else {
            return node;
        }
        node = skew(node);
        node = split(node);
        return node;
    }

    private Node<T> skew(Node<T> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        } else if (node.left.level == node.level) {
            return rotateRight(node);
        }
        return node;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> temp = node.left;
        node.left = temp.right;
        temp.right = node;
        return temp;
    }

    private Node<T> split(Node<T> node) {
        if (node == null) {
            return null;
        } else if (node.right == null || node.right.right == null) {
            return node;
        } else if (node.level == node.right.right.level) {
            node = rotateLeft(node);
            node.level = node.level + 1;
            return node;
        }
        return node;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> temp = node.right;
        node.right = temp.left;
        temp.left = node;
        return temp;
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            int count = 1;
            count += countNodes(node.left);
            count += countNodes(node.right);
            return count;
        }
    }

    public boolean search(T element) {
        return search(root, element);
    }

    private boolean search(Node<T> node, T element) {
        boolean found = false;
        while (node != null && !found) {
            int cmp = element.compareTo(node.element);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                found = true;
                break;
            }
            found = search(node, element);
        }
        return found;
    }

    public void inOrder(Consumer<T> consumer) {
        inOrder(root, consumer);
    }

    private void inOrder(Node<T> node, Consumer<T> consumer) {
        if (node != null) {
            inOrder(node.left, consumer);
            consumer.accept(node.element);
            inOrder(node.right, consumer);
        }
    }

    public void preOrder(Consumer<T> consumer) {
        preOrder(root, consumer);
    }

    private void preOrder(Node<T> node, Consumer<T> consumer) {
        if (node != null) {
            consumer.accept(node.element);
            preOrder(node.left, consumer);
            preOrder(node.right, consumer);
        }
    }

    public void postOrder(Consumer<T> consumer) {
        postOrder(root, consumer);
    }

    private void postOrder(Node<T> node, Consumer<T> consumer) {
        if (node != null) {
            postOrder(node.left, consumer);
            postOrder(node.right, consumer);
            consumer.accept(node.element);
        }
    }
}