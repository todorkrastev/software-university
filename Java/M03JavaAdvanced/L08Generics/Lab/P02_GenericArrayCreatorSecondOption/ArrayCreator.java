package GenericArrayCreatorSecondOption;

import java.lang.reflect.Array;
import java.util.stream.IntStream;

public class ArrayCreator {

    @SuppressWarnings("uncheked")
    public static <T> T[] create(int length, T value) {
        return create(value.getClass(), length, value);
    }

    @SuppressWarnings("uncheked")
    public static <T> T[] create(Class<?> clazz, int length, T value) {
        T[] arr = (T[]) Array.newInstance(clazz, length);

        IntStream.range(0, length)
                .forEach(i -> arr[i] = value);

        return arr;
    }
}
