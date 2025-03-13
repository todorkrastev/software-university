package implementations;

import interfaces.AbstractTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Tree<E> implements AbstractTree<E> {
    private E key;
    private Tree<E> parent;
    private final List<Tree<E>> children;

    public Tree(E key) {
        this.key = key;
        this.children = new ArrayList<>();
    }

    public Tree() {
        this.children = new ArrayList<>();
    }

    @Override
    public void setParent(Tree<E> parent) {
        this.parent = parent;
    }

    @Override
    public void addChild(Tree<E> child) {
        this.children.add(child);
    }

    @Override
    public Tree<E> getParent() {
        return this.parent;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public String getAsString() {
        StringBuilder sb = new StringBuilder();

        traverseTreeWithRecursion(sb, 0, this);

        return sb.toString().trim();
    }

    public List<Tree<E>> traverseTreeWithBFS() {
        Deque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);

        List<Tree<E>> allNodes = new ArrayList<>();

        while (!queue.isEmpty()) {
            Tree<E> current = queue.poll();
            allNodes.add(current);

            for (Tree<E> child : current.children) {
                queue.offer(child);
            }
        }

        return allNodes;
    }

    private void traverseTreeWithDFS(List<Tree<E>> collection, Tree<E> tree) {
        collection.add(tree);
        for (Tree<E> child : tree.children) {
            traverseTreeWithDFS(collection, child);
        }
    }


    private void traverseTreeWithRecursion(StringBuilder sb, int indent, Tree<E> tree) {
        sb
                .append(this.getPadding(indent))
                .append(tree.getKey())
                .append(System.lineSeparator());

        for (Tree<E> child : tree.children) {
            traverseTreeWithRecursion(sb, indent + 2, child);
        }
    }

    private String getPadding(int size) {
        return " ".repeat(Math.max(0, size));
    }

    @Override
    public List<E> getLeafKeys() {
        return traverseTreeWithBFS()
                .stream()
                .filter(e -> e.children.isEmpty())
                .map(Tree::getKey)
                .collect(Collectors.toList());

    }

    @Override
    public List<E> getMiddleKeys() {
        List<Tree<E>> allNodes = new ArrayList<>();
        traverseTreeWithDFS(allNodes, this);
        return allNodes
                .stream()
                .filter(e -> e.parent != null && !e.children.isEmpty())
                .map(Tree::getKey)
                .collect(Collectors.toList());

//        return traverseTreeWithBFS()
//                .stream()
//                .filter(e -> e.parent != null && !e.children.isEmpty())
//                .map(Tree::getKey)
//                .collect(Collectors.toList());
    }

    @Override
    public Tree<E> getDeepestLeftmostNode() {
//        List<Tree<E>> allNodes = traverseTreeWithBFS();
//        int maxDepth = 0;
//        Tree<E> deepestNode = null;
//
//        for (Tree<E> node : allNodes) {
//            int currentDepth = this.getDepth(node);
//            if (currentDepth > maxDepth) {
//                maxDepth = currentDepth;
//                deepestNode = node;
//            }
//        }
//
//        return deepestNode;

        List<Tree<E>> leftmostNodes = new ArrayList<>();
        int[] maxDepth = new int[1];
        int depth = 0;

        leftmostNodes.add(new Tree<>());

        findDeepestLeftmostNodeDFS(leftmostNodes, maxDepth, depth, this);
        return leftmostNodes.get(0);
    }

    private void findDeepestLeftmostNodeDFS(List<Tree<E>> leftmostNode, int[] maxDepth, int depth, Tree<E> tree) {

        if (depth > maxDepth[0]) {
            maxDepth[0] = depth;
            leftmostNode.set(0, tree);
        }

        for (Tree<E> child : tree.children) {
            findDeepestLeftmostNodeDFS(leftmostNode, maxDepth, depth + 1, child);
        }
    }

    private int getDepth(Tree<E> node) {
        int depth = 0;
        Tree<E> current = node;
        while (current.parent != null) {
            depth++;
            current = current.parent;
        }
        return depth;
    }

    @Override
    public List<E> getLongestPath() {
        List<E> longestPath = new ArrayList<>();
        getLongestPath(this, longestPath, new ArrayList<>());

        return longestPath;
    }

    private void getLongestPath(Tree<E> node, List<E> longestPath, ArrayList<E> currentPath) {
        currentPath.add(node.getKey());
        for (Tree<E> child : node.children) {
            getLongestPath(child, longestPath, currentPath);
        }
        if (currentPath.size() > longestPath.size()) {
            longestPath.clear();
            longestPath.addAll(currentPath);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    @Override
    public List<List<E>> pathsWithGivenSum(int sum) {
        List<List<E>> paths = new ArrayList<>();
        findPathsWithSum(sum, this, paths, new ArrayList<>());
        return paths;
    }

    private void findPathsWithSum(int sum, Tree<E> node, List<List<E>> paths, List<E> currentPath) {
        currentPath.add(node.getKey());
        if (sum == currentPath.stream().mapToInt(x -> (Integer) x).sum()) {
            paths.add(List.copyOf(currentPath));
        }
        for (Tree<E> child : node.children) {
            findPathsWithSum(sum, child, paths, currentPath);
        }

        currentPath.remove(currentPath.size()-1);
    }


    @Override
    public List<Tree<E>> subTreesWithGivenSum(int sum) {
        List<Tree<E>> subtrees = new ArrayList<>();
        findSubtreesWithGivenSum(sum, this, subtrees);
        return subtrees;
    }

    private void findSubtreesWithGivenSum(int sum, Tree<E> tree, List<Tree<E>> subtrees) {
        int treeSum = calculateTreeSum(tree);
        if (sum == treeSum){
            subtrees.add(tree);
        }

        for (Tree<E> child : tree.children) {
            findSubtreesWithGivenSum(sum, child,subtrees);
        }

    }

    private int calculateTreeSum(Tree<E> tree) {
        int sum = 0;
        sum += (Integer) tree.getKey();
        for (Tree<E> child : tree.children) {
            sum += calculateTreeSum(child);
        }

        return sum;
    }

}



