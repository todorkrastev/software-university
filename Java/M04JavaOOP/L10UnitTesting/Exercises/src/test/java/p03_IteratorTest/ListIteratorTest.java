package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private ListIterator listIterator;
    private static final String[] ELEMENTS = {"A", "B", "C", "D"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCreatingListIteratorShouldThrowWithNullAsParameter() throws OperationNotSupportedException {
        new ListIterator((String[]) null);
    }

    @Test
    public void testMoveShouldReturnCorrectBoolean() {
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test
    public void testHasNextShouldReturnCorrectBoolean() {
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testPrintShouldThrowWithNonExistingElements() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintShouldPrintCorrectElements() {
        for (int index = 0; listIterator.hasNext(); listIterator.move()) {
            assertEquals(ELEMENTS[index++], listIterator.print());
        }
    }
}