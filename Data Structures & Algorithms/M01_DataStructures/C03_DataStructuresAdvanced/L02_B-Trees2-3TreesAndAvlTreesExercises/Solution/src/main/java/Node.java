public class Node<T extends Comparable<T>> {

    public T value;
    public Node<T> left;
    public Node<T> right;

    public int height;

    public Node(T value) {
        this.value = value;
        this.height = 1;
    }

}
