package implementations;

import interfaces.AbstractBinarySearchTree;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    private Node<E> root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Node<E> node) {
        copy(node);
    }

    private void copy(Node<E> node) {
        if (node != null) {
            this.insert(node.value);
            copy(node.leftChild);
            copy(node.rightChild);
        }
    }

    @Override
    public void insert(E element) {
        if (root == null) {
            root = new Node<>(element);
            return;
        } else {
            Node<E> node = root;
            Node<E> parent = root;
            Node<E> newNode = new Node<>(element);
            while (node != null) {
                parent = node;
                if (less(newNode, node)) {
                    node = node.leftChild;
                } else if (greater(newNode, node)) {
                    node = node.rightChild;
                } else {
                    break;
                }
            }

            if (less(newNode, parent)) {
                parent.leftChild = newNode;
            } else if (greater(newNode, parent)) {
                parent.rightChild = newNode;
            }
        }
    }

    @Override
    public boolean contains(E element) {
        Node<E> node = this.root;
        while (node != null) {
            Node<E> newNode = new Node<>(element);
            if (less(newNode, node)) {
                node = node.leftChild;
            } else if (greater(newNode, node)) {
                node = node.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        Node<E> node = this.root;
        while (node != null) {
            Node<E> newNode = new Node<>(element);
            if (less(newNode, node)) {
                node = node.leftChild;
            } else if (greater(newNode, node)) {
                node = node.rightChild;
            } else {
                return new BinarySearchTree<>(node);
            }
        }
        return null;
    }

    @Override
    public Node<E> getRoot() {
        return this.root;
    }

    @Override
    public Node<E> getLeft() {
        return this.root.leftChild;
    }

    @Override
    public Node<E> getRight() {
        return this.root.rightChild;
    }

    @Override
    public E getValue() {
        return this.root.value;
    }

    private boolean greater(Node<E> newNode, Node<E> node) {
        return newNode.value.compareTo(node.value) > 0;
    }

    private boolean less(Node<E> newNode, Node<E> node) {
        return newNode.value.compareTo(node.value) < 0;
    }
}