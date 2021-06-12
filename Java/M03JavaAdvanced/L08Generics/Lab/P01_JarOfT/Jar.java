package JarOfT;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> element;

    public Jar() {
        this.element = new ArrayDeque<>();
    }

    public void add(T element) {
        this.element.push(element);
    }

    public T remove() {
        return this.element.pop();
    }
}
