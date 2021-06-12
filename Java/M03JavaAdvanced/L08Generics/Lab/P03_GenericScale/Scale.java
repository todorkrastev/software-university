package P03_GenericScale;

public class Scale<T extends Comparable<T>> {
    private final T left;
    private final T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        int result = left.compareTo(right);

        if (0 < result) {
            return left;
        }

        if (result < 0) {
            return right;
        }
        return null;
    }
}
