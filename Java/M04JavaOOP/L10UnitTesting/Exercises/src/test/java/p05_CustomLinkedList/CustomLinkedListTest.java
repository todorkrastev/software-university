package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    private static CustomLinkedList<Integer> list;
    private static final Integer testIntegerOne = 10;
    private static final Integer testIntegerTwo = 20;
    private static final Integer testIntegerThree = 30;
    private static final Integer testIntegerFour = 40;

    @Before
    public void setUp() {
        list = new CustomLinkedList<>();
        list.add(testIntegerOne);
        list.add(testIntegerTwo);
        list.add(testIntegerThree);
    }

    @Test
    public void testConstructorShouldSetCorrectValue() {
        list = new CustomLinkedList<>();
        assertFalse(list.contains(null));
    }

    @Test
    public void testAddDataShouldMustAddCorrectData() {
        assertEquals(testIntegerThree, list.get(2));
        assertEquals(testIntegerTwo, list.get(1));
        assertEquals(testIntegerOne, list.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMustFailsWhenIndexOutOfBounds() {
        list = new CustomLinkedList<>();
        list.get(0);
    }

    @Test
    public void testRemoveDataFromSpecifiedIndexMustReturnCorrectData() {
        assertEquals(testIntegerTwo, list.removeAt(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveDataFromSpecifiedIndexMustFailsWhenIndexOutOfBounds() {
        list.removeAt(4);
    }

    @Test
    public void testRemoveDataIfExistReturnIndexOfRemovedData() {
        assertEquals(0, list.remove(testIntegerOne));
    }

    @Test
    public void testRemoveIfDataIsNotExistReturnNegativeIndex() {
        assertEquals(-1, list.remove(testIntegerFour));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAllDataMustFailsWhenContinueRemovingAfterListIsEmpty(){
        list.removeAt(0);
        list.removeAt(0);
        list.removeAt(0);
        list.removeAt(0);
    }

    @Test
    public void testIndexOfMustReturnCorrectIndexOfGivenObject() {
        assertEquals(2, list.indexOf(testIntegerThree));
        assertEquals(0,list.indexOf(testIntegerOne));
    }

    @Test
    public void testSetMustSetCorrectValueAtTheGivenIndex() {
        list.set(0,testIntegerFour);
        assertEquals(testIntegerFour,list.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetMustFailsIfTheGivenIndexIsOutOfBoundsOrListIsEmpty() {
        list.set(4,testIntegerFour);
        list = new CustomLinkedList<>();
        list.set(0,testIntegerFour);
    }
}