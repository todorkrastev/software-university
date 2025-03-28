package test.helpers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class IterableExtensions {

    public static <E> long getCount(Iterable<E> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection)iterable).size();
        }

        return StreamSupport.stream(iterable.spliterator(), false).count();
    }

    public static <T extends Iterable<E>, E> Stream<E> take(Iterable<E> iterable, int count) {

        return StreamSupport.stream(iterable.spliterator(), false).limit(count);
    }

    public static <E> boolean contains(Iterable<E> iterable, E value) {
        for (E item : iterable) {
            if (item.equals(value)) {
                return true;
            }
        }

        return false;
    }

    public static <E> List<E> toList(Iterable<E> iterable) {
        List<E> result = new ArrayList<>();
        for (E item : iterable) {
            result.add(item);
        }

        return result;
    }
}
