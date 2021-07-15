package bg.softuni.java_oop.interfaces_and_abstraction.exercises.P07_CollectionHierarchy;

public class AddCollection extends Collection implements Addable {
    public AddCollection() {
        super();
    }

    @Override
    public int add(String item) {
        getItems().add(item);
        return getItems().indexOf(item);
    }
}
