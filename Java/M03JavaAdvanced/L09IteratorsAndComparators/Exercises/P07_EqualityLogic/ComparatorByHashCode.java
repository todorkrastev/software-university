package bg.softuni.java_advanced.iterators_and_comparators.exercises.P07_EqualityLogic;

import java.util.Comparator;

public class ComparatorByHashCode implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        return Integer.compare(first.hashCode(), second.hashCode());
    }
}
