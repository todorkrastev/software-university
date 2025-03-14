import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinarySearchTree<E extends Comparable<E>> {

    private Node<E> root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Node<E> node) {
        this.copy(node);
    }

    private void copy(Node<E> node) {
        if (node == null) return;
        this.insert(node.value);
        copy(node.leftChild);
        copy(node.rightChild);
    }

    public void insert(E element) {
        if (this.root == null) {
            this.root = new Node<>(element);
        } else {
            insertInto(this.root, element);
        }
    }

    private void insertInto(Node<E> node, E element) {
        if (less(element, node.value)) {
            if (node.leftChild == null) {
                node.leftChild = new Node<>(element);
            } else {
                insertInto(node.leftChild, element);
            }
        } else if (greater(element, node.value)) {
            if (node.rightChild == null) {
                node.rightChild = new Node<>(element);
            } else {
                insertInto(node.getRight(), element);
            }
        }
        node.count++;
    }

    public void eachInOrder(Consumer<E> consumer) {
        eachInOrder(this.root, consumer);
    }

    private void eachInOrder(Node<E> node, Consumer<E> consumer) {
        if (node == null) return;
        eachInOrder(node.leftChild, consumer);
        consumer.accept(node.value);
        eachInOrder(node.rightChild, consumer);
    }

    public Node<E> getRoot() {
        return this.root;
    }

    public boolean contains(E element) {
        Node<E> current = this.root;
        while (current != null) {
            if (less(element, current.value)) {
                current = current.leftChild;
            } else if (greater(element, current.getValue())) {
                current = current.rightChild;
            } else {
                break;
            }
        }

        return current != null;
    }

    public BinarySearchTree<E> search(E element) {
        Node<E> current = this.root;
        while (current != null) {
            if (less(element, current.value)) {
                current = current.leftChild;
            } else if (greater(element, current.getValue())) {
                current = current.rightChild;
            } else {
                break;
            }
        }

        return current == null ? null : new BinarySearchTree<>(current);
    }

    public List<E> range(E first, E second) {
        List<E> result = new ArrayList<>();
        this.eachInOrder(x -> {
            if (x.compareTo(first) >= 0 && x.compareTo(second) < 0) {
                result.add(x);
            }
        });
        return result;
    }

    public void deleteMin() {
        ensureNonEmpty();
        deleteMin(this.root);
    }

    private void deleteMin(Node<E> node) {
        if (node.leftChild == null) {
            node = node.rightChild;
            return;
        }
        if (node.leftChild.leftChild != null) {
            deleteMin(node.leftChild);
        } else {
            node.leftChild = node.leftChild.rightChild;
        }
        node.count--;
    }

    public void deleteMax() {
        ensureNonEmpty();
        deleteMax(this.root);
    }

    private void deleteMax(Node<E> node) {
        if (node.rightChild == null) {
            node = node.leftChild;
        }
        if (node.rightChild.rightChild != null) {
            deleteMax(node.rightChild);
        } else {
            node.rightChild = node.rightChild.leftChild;
        }
        node.count--;
    }

    public int count() {
        return this.root == null ? 0 : this.root.count;
    }

    public int rank(E element) {
        return rank(this.root, element);
    }

    private int rank(Node<E> node, E element) {
        if (node == null) return 0;

        if (less(element, node.value)) {
            return rank(node.leftChild, element);
        } else if (element.equals(node.value)) {
            return getNodeCount(node.getLeft());
        }
        return getNodeCount(node.getLeft()) + 1 + rank(node.rightChild, element);
    }

    private int getNodeCount(Node<E> node) {
        return node == null ? 0 : node.count;
    }

    public E floor(E element) {
        if (this.root == null) return null;

        Node<E> current = this.root;
        Node<E> nearestSmaller = null;

        while (current != null) {
            if (greater(element, current.value)) {
                nearestSmaller = current;
                current = current.rightChild;
            } else if (less(element, current.value)) {
                current = current.leftChild;
            } else {
                Node<E> left = current.leftChild;
                if (left != null && nearestSmaller != null) {
                    nearestSmaller = greater(nearestSmaller.value, left.value) ? nearestSmaller : left;
                } else if (nearestSmaller == null) {
                    nearestSmaller = left;
                }
                break;
            }
        }

        return nearestSmaller == null ? null : nearestSmaller.value;
    }

    public E ceil(E element) {
        if (this.root == null) return null;

        Node<E> current = this.root;
        Node<E> nearestGrearer = null;

        while (current != null) {
            if (less(element, current.value)) {
                nearestGrearer = current;
                current = current.leftChild;
            } else if (greater(element, current.value)) {
                current = current.rightChild;
            } else {
                Node<E> right = current.rightChild;
                if (right != null && nearestGrearer != null) {
                    nearestGrearer = less(nearestGrearer.value, right.value) ? nearestGrearer : right;
                } else if (nearestGrearer == null) {
                    nearestGrearer = right;
                }
                break;
            }
        }

        return nearestGrearer == null ? null : nearestGrearer.value;
    }

    private boolean less(E first, E second) {
        return first.compareTo(second) < 0;
    }

    private boolean greater(E first, E second) {
        return first.compareTo(second) > 0;
    }

    private void ensureNonEmpty() {
        if (this.root == null || this.root.value == null)
            throw new IllegalArgumentException("Illegal call on empty BST");
    }

    public static class Node<E> {

        private E value;
        private Node<E> leftChild;
        private Node<E> rightChild;
        private int count;

        public Node(E value) {
            this.value = value;
            this.count = 1;
        }

        public Node<E> getLeft() {
            return this.leftChild;
        }

        public Node<E> getRight() {
            return this.rightChild;
        }

        public E getValue() {
            return this.value;
        }

    }
}