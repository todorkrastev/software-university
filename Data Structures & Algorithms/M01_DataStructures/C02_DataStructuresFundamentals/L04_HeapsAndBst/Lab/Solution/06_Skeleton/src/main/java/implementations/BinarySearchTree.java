package implementations;

import interfaces.AbstractBinarySearchTree;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {

    @Override
    public void insert(E element) {

    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        return null;
    }

    @Override
    public Node<E> getRoot() {
        return null;
    }

    @Override
    public Node<E> getLeft() {
        return null;
    }

    @Override
    public Node<E> getRight() {
        return null;
    }

    @Override
    public E getValue() {
        return null;
    }
}
