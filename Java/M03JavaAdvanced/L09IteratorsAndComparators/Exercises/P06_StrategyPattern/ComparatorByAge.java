package bg.softuni.java_advanced.iterators_and_comparators.exercises.P06_StrategyPattern;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        return Integer.compare(first.getAge(), second.getAge());
    }
}
