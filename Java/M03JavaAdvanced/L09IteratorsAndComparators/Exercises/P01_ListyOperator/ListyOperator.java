package bg.softuni.java_advanced.iterators_and_comparators.exercises.P01_ListyOperator;

import java.util.List;

public class ListyOperator {
    private final List<String> stringList;
    private int index;

    ListyOperator(List<String> stringList) {
        this.stringList = stringList;
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public void print() {
        if (isIndexInBounds()) {
            System.out.println(this.stringList.get(index));
        }
    }

    private boolean isIndexInBounds() {
        if (this.stringList.isEmpty()) {
            System.out.println("Invalid Operation!");
            return false;
        }
        return true;
    }

    public boolean hasNext() {
        return index < stringList.size() - 1;
    }
}
