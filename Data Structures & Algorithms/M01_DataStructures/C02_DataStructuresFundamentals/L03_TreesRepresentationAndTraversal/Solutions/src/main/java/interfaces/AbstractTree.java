package interfaces;

import implementations.Tree;

import java.util.List;

public interface AbstractTree<E> {
    void setParent(Tree<E> parent);

    void addChild(Tree<E> child);

    Tree<E> getParent();

    E getKey();

    String getAsString();

    List<E> getLeafKeys();

    List<E> getMiddleKeys();

    Tree<E> getDeepestLeftmostNode();

    List<E> getLongestPath();

    List<List<E>> pathsWithGivenSum(int sum);

    List<Tree<E>> subTreesWithGivenSum(int sum);
}
