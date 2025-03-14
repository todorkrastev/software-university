package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BinaryTree {
    private final int key;
    private final BinaryTree left;
    private final BinaryTree right;
    private static Map<Integer, Pair<Integer,Integer>> horizontalDistances = new TreeMap<>();


    public BinaryTree(int key, BinaryTree first, BinaryTree second) {
        this.key = key;
        this.left = first;
        this.right = second;
    }

    public Integer findLowestCommonAncestor(int first, int second) {
        List<Integer> firstPath = findPath(this, first);
        List<Integer> secondPath = findPath(this, second);

        int smallerSize = Math.min(firstPath.size(), secondPath.size());

        int i = 0;
        for (; i < smallerSize; i++) {
            if (!firstPath.get(i).equals(secondPath.get(i))) {
                break;
            }
        }

        return firstPath.get(i - 1);
    }

    private List<Integer> findPath(BinaryTree binaryTree, int element) {
        List<Integer> path = new ArrayList<>();
        findNodePath(binaryTree, element, path);
        return path;
    }

    private boolean findNodePath(BinaryTree binaryTree, int element, List<Integer> path) {
        if (binaryTree == null) return false;
        if (binaryTree.key == element) return true;
        path.add(binaryTree.key);
        boolean leftResult = findNodePath(binaryTree.left, element, path);
        if (leftResult) {
            return true;
        }

        boolean rightResult = findNodePath(binaryTree.right, element, path);
        if (rightResult) {
            return true;
        }
        path.remove(Integer.valueOf(binaryTree.key));
        return false;
    }

    public List<Integer> topView() {
        // create a `TreeMap` where
        // key —> relative horizontal distance of the node from the root node, and
        // value —> pair containing the node's value and its level
        Map<Integer, Pair<Integer, Integer>> map = new TreeMap<>();

        // perform preorder traversal on the tree and fill the map
        buildMap(this, 0, 0, map);

        return map.entrySet().stream().map(x->x.getValue().first).collect(Collectors.toList());
    }

    // Recursive function to perform preorder traversal on the tree and fill the map.
    // Here, the node has `dist` horizontal distance from the tree's root,
    // and the level represents the node's level.
    public void buildMap(BinaryTree root, int dist, int level,
                         Map<Integer, Pair<Integer, Integer>> map)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }
        // if the current level is less than the maximum level seen so far
        // for the same horizontal distance, or if the horizontal distance
        // is seen for the first time, update the map
        if (!map.containsKey(dist) || level < map.get(dist).second)
        {
            // update value and level for current distance
            map.put(dist, Pair.of(root.key, level));
        }

        // recur for the left subtree by decreasing horizontal distance and
        // increasing level by 1
        buildMap(root.left, dist - 1, level + 1, map);

        // recur for the right subtree by increasing both level and
        // horizontal distance by 1
        buildMap(root.right, dist + 1, level + 1, map);
    }
}

class Pair<U, V>
{
    public final U first;       // first field of a pair
    public final V second;      // second field of a pair

    // Constructs a new Pair with specified values
    private Pair(U first, V second)
    {
        this.first = first;
        this.second = second;
    }

    // Factory method for creating a Typed Pair immutable instance
    public static <U, V> Pair <U, V> of(U a, V b)
    {
        // calls private constructor
        return new Pair<>(a, b);
    }
}