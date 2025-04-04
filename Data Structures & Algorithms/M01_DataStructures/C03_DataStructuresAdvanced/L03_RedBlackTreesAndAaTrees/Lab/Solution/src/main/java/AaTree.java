import java.util.function.Consumer;

public class AaTree<T extends Comparable<T>> {

    private Node<T> root;

    public AaTree() {
    }

    private AaTree(Node<T> node) {
        this.preOrderCopy(node);
    }

    private void preOrderCopy(Node<T> node) {
        if (node == null) {
            return;
        }

        this.insert(node.value);
        this.preOrderCopy(node.left);
        this.preOrderCopy(node.right);
    }

    public void insert(T value) {
        this.root = this.insert(this.root, value);
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }

        if (node.value.compareTo(value) > 0) {
            node.left = this.insert(node.left, value);
        } else if (node.value.compareTo(value) < 0) {
            node.right = this.insert(node.right, value);
        }

        node = skew(node);
        node = split(node);

        return node;
    }

    private Node<T> split(Node<T> node) {
        if (node.right == null || node.right.right == null) {
            return node;
        }

        Node<T> result = node.right;
        result.left = node;
        node.right = null;
        result.level++;

        return result;
    }

    private Node<T> skew(Node<T> node) {
        if (node.left == null) {
            return node;
        }

        if (node.level == node.left.level) {
            Node<T> result = node.left;
            result.right = node;
            node.left = null;

            node = result;
        }

        return node;
    }

    public boolean contains(T value) {
        return this.findElement(value) != null;
    }

    public AaTree<T> search(T item) {
        return new AaTree<>(this.findElement(item));
    }

    private Node<T> findElement(T item) {
        Node<T> current = this.root;
        while (current != null) {
            if (item.compareTo(current.value) < 0) {
                current = current.left;
            } else if (item.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                break;
            }
        }
        return current;
    }

    public void eachInOrder(Consumer<T> consumer) {
        this.eachInOrder(this.root, consumer);
    }

    private void eachInOrder(Node<T> node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }

        this.eachInOrder(node.left, consumer);
        consumer.accept(node.value);
        this.eachInOrder(node.right, consumer);
    }

    public static class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> left;
        private Node<T> right;
        private int level;

        public Node(T value) {
            this.value = value;
            this.level = 1;
        }
    }
}

