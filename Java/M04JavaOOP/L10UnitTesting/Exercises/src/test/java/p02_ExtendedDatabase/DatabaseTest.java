package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;
    private static final Person[] EXPECTED = {
            new Person(1, "First"),
            new Person(2, "Second"),
            new Person(3, "Third"),
            new Person(4, "Fourth")
    };

    @Before
    public void setUp() throws OperationNotSupportedException {
        Person firstPerson = new Person(1, "First");
        Person secondPerson = new Person(2, "Second");
        Person thirdPerson = new Person(3, "Third");
        Person fourthPerson = new Person(4, "Fourth");
        database = new Database(firstPerson, secondPerson, thirdPerson, fourthPerson);
    }

    @Test
    public void testDatabaseConstructorShouldCreateObjectWithValidState() {
        Person[] elements = database.getElements();
        assertEquals(EXPECTED.length, elements.length);
        for (int i = 0; i < EXPECTED.length; i++) {
            assertEquals(EXPECTED[i], elements[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseConstructorShouldThrowWhenIsCalledWithMoreThanSixteenElements() throws OperationNotSupportedException {
        Person[] numbers = new Person[17];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseConstructorShouldThrowWhenIsCalledWithZeroElements() throws OperationNotSupportedException {
        Person[] numbers = new Person[0];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowWhenParameterIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddShouldAddAtFirstFreeIndex() throws OperationNotSupportedException {
        Person fifthPerson = new Person(5, "Fifth");
        database.add(fifthPerson);
        Person[] elements = database.getElements();
        assertEquals(5, elements.length);
        assertEquals(fifthPerson, elements[4]);
    }

    @Test
    public void testRemoveShouldRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Person[] actual = database.getElements();
        Person[] expected = {
                new Person(1, "First"),
                new Person(2, "Second"),
                new Person(3, "Third")
        };
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowWithEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < 4; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testGetElementShouldReturnCorrectArray() {
        Person[] actual = database.getElements();
        assertEquals(EXPECTED.length, actual.length);
        for (int i = 0; i < EXPECTED.length; i++) {
            assertEquals(EXPECTED[i], actual[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddDuplicatePersonShouldThrow() throws OperationNotSupportedException {
        this.database.add(new Person(1, "First"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddPersonWithNegativeIdShouldThrow() throws OperationNotSupportedException {
        this.database.add(new Person(-1, "Minus One"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameWithNullParameterShouldThrow() throws OperationNotSupportedException {
        this.database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameWithNonExistingUserShouldThrow() throws OperationNotSupportedException {
        this.database.findByUsername("Non_Existing_Username");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameDuplicatingUsernameShouldThrow() throws OperationNotSupportedException {
        Person firstPerson = new Person(1, "First");
        Person secondPerson = new Person(2, "Second");
        Person thirdPerson = new Person(3, "Fourth");
        Person fourthPerson = new Person(3, "Fourth");
        Database database = new Database(firstPerson, secondPerson, thirdPerson, fourthPerson);
        database.findByUsername("Fourth");
    }

    @Test
    public void testFindByUsernameShouldReturnTheCorrectPerson() throws OperationNotSupportedException {
        Person person = this.database.findByUsername("Fourth");
        assertEquals(new Person(4, "Fourth"), person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdWithNonExistingIdShouldThrow() throws OperationNotSupportedException {
        this.database.findById(100);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdDuplicatingIdShouldThrow() throws OperationNotSupportedException {
        Person firstPerson = new Person(1, "First");
        Person secondPerson = new Person(2, "Second");
        Person thirdPerson = new Person(3, "Fourth");
        Person fourthPerson = new Person(3, "Fourth");
        Database database = new Database(firstPerson, secondPerson, thirdPerson, fourthPerson);
        database.findById(3);
    }

    @Test
    public void testFindByIdShouldReturnCorrectPerson() throws OperationNotSupportedException {
        Person byId = this.database.findById(1);
        assertEquals(1, byId.getId());
        assertEquals("First", byId.getUsername());
    }
}