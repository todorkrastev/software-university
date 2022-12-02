package implementations;

import interfaces.AbstractTree;

import java.util.*;

public class Tree<E> implements AbstractTree<E> {
    private E key;
    private Tree<E> parent;
    private List<Tree<E>> children;

    @SafeVarargs
    public Tree(E key, Tree<E>... subtrees) {
        this.key = key;
        this.parent = null;
        this.children = new ArrayList<>();

        for (Tree<E> subtree : subtrees) {
            this.children.add(subtree);
            subtree.parent = this;
        }
    }

    @Override
    public List<E> orderBfs() {
        List<E> result = new ArrayList<>();
        if (this.key != null) {
            Deque<Tree<E>> childrenQueue = new ArrayDeque<>();

            childrenQueue.offer(this);

            while (!childrenQueue.isEmpty()) {
                Tree<E> current = childrenQueue.poll();

                result.add(current.key);

                for (Tree<E> child : current.children) {
                    childrenQueue.offer(child);
                }
            }
        }
        return result;
    }

    @Override
    public List<E> orderDfs() {
        List<E> result = new ArrayList<>();

        this.doDfs(this, result);

/*        Deque<Tree<E>> toTraverse = new ArrayDeque<>();
        toTraverse.push(this);

        while (!toTraverse.isEmpty()) {
            Tree<E> current = toTraverse.pop();

            for (Tree<E> node : current.children) {
                toTraverse.push(node);
            }

            result.add(current.value);
        }*/

        return result;
    }

    private void doDfs(Tree<E> node, List<E> result) {
        for (Tree<E> child : node.children) {
            this.doDfs(child, result);
        }

        result.add(node.key);
    }

    @Override
    public void addChild(E parentKey, Tree<E> child) {
        // Tree<E> search = findBfs(parentKey);
        Tree<E> search = findDfs(this, parentKey);

        if (search == null) {
            throw new IllegalArgumentException();
        }

        search.children.add(child);
        child.parent = search;
    }

    private Tree<E> findBfs(E parentKey) {
        Deque<Tree<E>> childrenQueue = new ArrayDeque<>();

        childrenQueue.offer(this);

        while (!childrenQueue.isEmpty()) {
            Tree<E> current = childrenQueue.poll();

            if (current.key.equals(parentKey)) {
                return current;
            }

            for (Tree<E> child : current.children) {
                childrenQueue.offer(child);
            }
        }

        return null;
    }

    private Tree<E> findDfs(Tree<E> current, E parentKey) {
        if (current.key.equals(parentKey)) {
            return current;
        }

        for (Tree<E> child : current.children) {
            Tree<E> found = this.findDfs(child, parentKey);
            if (found != null) {
                return found;
            }
        }

        return null;
    }

    @Override
    public void removeNode(E nodeKey) {
        Tree<E> toRemove = findBfs(nodeKey);

        if (toRemove == null) {
            throw new IllegalArgumentException();
        }

        for (Tree<E> child : toRemove.children) {
            child.parent = null;
        }
        toRemove.children.clear();

        Tree<E> parent = toRemove.parent;
        if (parent != null) {
            parent.children.remove(toRemove);
        }

        toRemove.key = null;
    }

    @Override
    public void swap(E firstKey, E secondKey) {
        Tree<E> firstNode = findBfs(firstKey);
        Tree<E> secondNode = findBfs(secondKey);

        if (firstNode == null || secondNode == null) {
            throw new IllegalArgumentException();
        }

        Tree<E> firstParent = firstNode.parent;
        Tree<E> secondParent = secondNode.parent;

        if (firstParent == null) {
            this.key = secondNode.key;
            this.parent = null;
            this.children = secondNode.children;
            return;
        } else if (secondParent == null) {
            this.key = firstNode.key;
            this.parent = null;
            this.children = firstNode.children;
            return;
        }

        firstNode.parent = secondParent;
        secondNode.parent = firstParent;

        int firstIndex = firstParent.children.indexOf(firstNode);
        int secondIndex = secondParent.children.indexOf(secondNode);

        firstParent.children.set(firstIndex, secondNode);
        secondParent.children.set(secondIndex, firstNode);
    }
}



