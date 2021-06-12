package P04_ListUtilities;

import java.util.Collections;
import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        ensureNotEmpty(list);
        return Collections.min(list);
    }

    private static <T extends Comparable<T>> void ensureNotEmpty(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("The list is empty!");
        }
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        ensureNotEmpty(list);
        return Collections.max(list);
    }
}
