package bg.softuni.java_advanced.generics.exercises.P08_CustomListSorterSecondOption;


public class Sorter {

    public Sorter() {
    }

    public static <T extends Comparable<T>> void sort(Box<T> box) {
        for (int i = 0; i < box.size(); i++) {
            T element = box.get(i);
            for (int j = i + 1; j < box.size(); j++) {
                T nextElement = box.get(j);
                if (element.compareTo(nextElement) > 0) {
                    box.swap(i, j);
                }
            }
        }
    }
}
