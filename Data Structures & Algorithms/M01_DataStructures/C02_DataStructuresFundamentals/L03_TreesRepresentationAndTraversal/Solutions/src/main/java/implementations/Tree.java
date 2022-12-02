package implementations;

import interfaces.AbstractTree;

import java.util.List;

public class Tree<E> implements AbstractTree<E> {

    @Override
    public void setParent(Tree<E> parent) {

    }

    @Override
    public void addChild(Tree<E> child) {

    }

    @Override
    public Tree<E> getParent() {
        return null;
    }

    @Override
    public E getKey() {
        return null;
    }

    @Override
    public String getAsString() {
        return null;
    }

    @Override
    public List<E> getLeafKeys() {
        return null;
    }

    @Override
    public List<E> getMiddleKeys() {
        return null;
    }

    @Override
    public Tree<E> getDeepestLeftmostNode() {
        return null;
    }

    @Override
    public List<E> getLongestPath() {
        return null;
    }

    @Override
    public List<List<E>> pathsWithGivenSum(int sum) {
        return null;
    }

    @Override
    public List<Tree<E>> subTreesWithGivenSum(int sum) {
        return null;
    }
}



