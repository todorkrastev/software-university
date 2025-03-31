public class TwoThreeTree<K extends Comparable<K>> {
    private TreeNode<K> root;

    public static class TreeNode<K> {
        private K leftKey;
        private K rightKey;

        public TreeNode(K parent, K left, K right) {
            this(parent);

            this.leftChild = new TreeNode<>(left);
            this.rightChild = new TreeNode<>(right);
        }

        public TreeNode(K parent, TreeNode<K> leftChild, TreeNode<K> rightChild) {
            this.leftKey = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        private TreeNode<K> leftChild;
        private TreeNode<K> middleChild;
        private TreeNode<K> rightChild;

        private TreeNode(K key) {
            this.leftKey = key;
        }

        boolean isThreeNode() {
            return rightKey != null;
        }

        boolean isTwoNode() {
            return rightKey == null;
        }

        boolean isLeaf() {
            return this.leftChild == null && this.middleChild == null && this.rightChild == null;
        }
    }

    public void insert(K key) {
        if (this.root == null) {
            this.root = new TreeNode<>(key);
            return;
        }

        TreeNode<K> result = insertNode(this.root, key);

        if (result != null) {
            this.root = result;
        }
    }

    private TreeNode<K> insertNode(TreeNode<K> node, K key) {
        if (node == null) return new TreeNode<>(key);

        if (node.isLeaf()) {
            if (node.isTwoNode()) {
                if (node.leftKey.compareTo(key) < 0) {
                    node.rightKey = key;
                } else {
                    node.rightKey = node.leftKey;
                    node.leftKey = key;
                }

                return null;
            } else {
                K left = node.leftKey;
                K middle = key;
                K right = node.rightKey;
                if (node.leftKey.compareTo(key) > 0) {
                    left = key;
                    middle = node.leftKey;
                } else if (node.rightKey.compareTo(key) < 0) {
                    middle = node.rightKey;
                    right = key;
                }

                return new TreeNode<>(middle, left, right);
            }
        }

        TreeNode<K> toFix;
        if (node.leftKey.compareTo(key) > 0) {
            toFix = insertNode(node.leftChild, key);
        } else if (node.isTwoNode() && node.leftKey.compareTo(key) < 0) {
            toFix = insertNode(node.rightChild, key);
        } else if (node.isThreeNode() && node.rightKey.compareTo(key) < 0) {
            toFix = insertNode(node.rightChild, key);
        } else { // 3 node, not less than left or greater than right
            toFix = insertNode(node.middleChild, key);
        }

        if (toFix == null) return null;

        if (node.isTwoNode()) {
            if (node.leftKey.compareTo(toFix.leftKey) < 0) {
                node.rightKey = toFix.leftKey;
                node.middleChild = toFix.leftChild;
                node.rightChild = toFix.rightChild;
            } else {
                node.rightKey = node.leftKey;
                node.leftKey = toFix.leftKey;
                node.leftChild = toFix.leftChild;
                node.middleChild = toFix.rightChild;
            }

            return null;
        }

        TreeNode<K> newNode;
        if (node.leftKey.compareTo(key) > 0) {
            K newKey = node.leftKey;
            node.leftKey = node.rightKey;
            newNode = new TreeNode<>(newKey, toFix, node);
        } else if (node.rightKey.compareTo(key) < 0) {
            K newKey = node.rightKey;
            node.rightKey = null;
            newNode = new TreeNode<>(newKey, node, toFix);
        } else {
            TreeNode<K> newLeft = new TreeNode<>(node.leftKey, node.leftChild, toFix.leftChild);
            TreeNode<K> newRight = new TreeNode<>(node.rightKey, toFix.rightChild, node.rightChild);

            newNode = new TreeNode<>(toFix.leftKey, newLeft, newRight);
        }

        return newNode;
    }

    public String getAsString() {
        StringBuilder out = new StringBuilder();
        recursivePrint(this.root, out);
        return out.toString().trim();
    }

    private void recursivePrint(TreeNode<K> node, StringBuilder out) {
        if (node == null) {
            return;
        }
        if (node.leftKey != null) {
            out.append(node.leftKey)
                    .append(" ");
        }
        if (node.rightKey != null) {
            out.append(node.rightKey).append(System.lineSeparator());
        } else {
            out.append(System.lineSeparator());
        }
        if (node.isTwoNode()) {
            recursivePrint(node.leftChild, out);
            recursivePrint(node.rightChild, out);
        } else if (node.isThreeNode()) {
            recursivePrint(node.leftChild, out);
            recursivePrint(node.middleChild, out);
            recursivePrint(node.rightChild, out);
        }
    }
}
