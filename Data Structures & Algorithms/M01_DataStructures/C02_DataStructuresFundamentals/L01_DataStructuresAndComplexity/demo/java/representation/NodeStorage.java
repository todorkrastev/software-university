package representation;

public class NodeStorage {

    private Node node;

    class Node {
        private int element;
        private Node next;

        Node(int element) {
            this.element = element;
        }
    }

    public NodeStorage() {
        this.node = new Node(0);
    }

    public boolean add(int element) {
        this.node.next = new Node(element);
        return true;
    }

    // TODO: How do we iterate over the items? How do we remove? How do we iterate and access data?
}
