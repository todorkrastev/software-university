import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HashTableTests {

    @Test
    public void Add_EmptyHashTable_NoDuplicates_ShouldAddElement() {
        // Arrange
        HashTable<String, Integer> hashTable = new HashTable<String, Integer>();

        // Act
        KeyValue<String, Integer>[] elements = new KeyValue[]{
                new KeyValue<String, Integer>("Peter", 5),
                new KeyValue<String, Integer>("Maria", 6),
                new KeyValue<String, Integer>("George", 4),
                new KeyValue<String, Integer>("Kiril", 5)
        };

        for (KeyValue<String, Integer> element : elements) {
            hashTable.add(element.getKey(), element.getValue());
        }

        for (KeyValue<String, Integer> element : elements) {
            Assert.assertTrue(hashTable.containsKey(element.getKey()));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void Add_EmptyHashTable_Duplicates_ShouldThrowException() {
        HashTable<String, String> hashTable = new HashTable<String, String>();
        hashTable.add("peter", "1");
        hashTable.add("peter", "2");
        // Act
    }

    @Test
    public void Add_1000_Elements_Grow_ShouldWorkCorrectly() {
        // Arrange
        HashTable<String, Integer> hashTable = new HashTable<String, Integer>(1);

        // Act
        List<KeyValue<String, Integer>> expectedElements = new ArrayList<KeyValue<String, Integer>>();
        for (Integer i = 0; i < 1000; i++) {
            hashTable.add("key" + i, i);
            expectedElements.add(new KeyValue<String, Integer>("key" + i, i));
        }

        // Assert
        for (KeyValue<String, Integer> expectedElement : expectedElements) {
            Assert.assertTrue(hashTable.containsKey(expectedElement.getKey()));
        }
    }

    @Test
    public void AddOrReplace_WithDuplicates_ShouldWorkCorrectly() {
        // Arrange
        HashTable<String, Integer> hashTable = new HashTable<String, Integer>();

        // Act
        hashTable.addOrReplace("Peter", 555);
        hashTable.addOrReplace("Maria", 999);
        hashTable.addOrReplace("Maria", 123);
        hashTable.addOrReplace("Maria", 6);
        hashTable.addOrReplace("Peter", 5);

        // Assert
        KeyValue<String, Integer>[] expectedElements = new KeyValue[]{
                new KeyValue<String, Integer>("Peter", 5),
                new KeyValue<String, Integer>("Maria", 6)
        };

        for (KeyValue<String, Integer> expectedElement : expectedElements) {
            Assert.assertTrue(hashTable.containsKey(expectedElement.getKey()));
        }
    }

    @Test
    public void Count_Empty_Add_Remove_ShouldWorkCorrectly() {
        // Arrange
        HashTable<String, Integer> hashTable = new HashTable<String, Integer>();

        // Assert
        Assert.assertEquals(0, hashTable.size());

        // Act & Assert
        hashTable.add("Peter", 555);
        hashTable.addOrReplace("Peter", 555);
        hashTable.addOrReplace("Ivan", 555);
        Assert.assertEquals(2, hashTable.size());

        // Act & Assert
        hashTable.remove("Peter");
        Assert.assertEquals(1, hashTable.size());

        // Act & Assert
        hashTable.remove("Peter");
        Assert.assertEquals(1, hashTable.size());

        // Act & Assert
        hashTable.remove("Ivan");
        Assert.assertEquals(0, hashTable.size());
    }

    @Test
    public void Get_ExistingElement_ShouldReturnTheValue() {
        // Arrange
        HashTable<Integer, String> hashTable = new HashTable<Integer, String>();
        hashTable.add(555, "Peter");

        // Act
        String actualValue = hashTable.get(555);

        // Assert
        Assert.assertEquals("Peter", actualValue);
    }

    // ===========================
    @Test(expected = IllegalArgumentException.class)
    public void Get_NonExistingElement_ShouldThrowException() {
        // Arrange
        HashTable<Integer, String> hashTable = new HashTable<Integer, String>();

        // Act
        hashTable.get(12345);
    }

    @Test
    public void Capacity_Grow_ShouldWorkCorrectly() {
        // Arrange
        HashTable<String, Integer> hashTable = new HashTable<String, Integer>(2);

        // Assert
        Assert.assertEquals(2, hashTable.capacity());

        // Act
        hashTable.add("Peter", 123);
        hashTable.add("Maria", 456);

        // Assert
        Assert.assertEquals(4, hashTable.capacity());

        // Act
        hashTable.add("Tanya", 555);
        hashTable.add("George", 777);

        // Assert
        Assert.assertEquals(8, hashTable.capacity());
    }

    @Test
    public void Find_ExistingElement_ShouldReturnTheElement() {
        // Arrange
        HashTable<String, Date> hashTable = new HashTable<String, Date>();
        String name = "Maria";
        Date date = new Date(1995, 7, 18);
        hashTable.add(name, date);

        // Act
        KeyValue<String, Date> element = hashTable.find(name);

        // Assert
        KeyValue<String, Date> expectedElement = new KeyValue<>(name, date);
        Assert.assertEquals(expectedElement, element);
    }

    @Test
    public void Find_NonExistingElement_ShouldReturnNull() {
        // Arrange
        HashTable<String, Date> hashTable = new HashTable<String, Date>();

        // Act
        KeyValue<String, Date> element = hashTable.find("Maria");

        // Assert
        Assert.assertNull(element);
    }

    @Test
    public void ContainsKey_ExistingElement_ShouldReturnTrue() {
        // Arrange
        HashTable<Date, String> hashTable = new HashTable<Date, String>();
        Date date = new Date(1995, 7, 18);
        hashTable.add(date, "Some value");

        // Act
        boolean containsKey = hashTable.containsKey(date);

        // Assert
        Assert.assertTrue(containsKey);
    }

    @Test
    public void ContainsKey_NonExistingElement_ShouldReturnFalse() {
        // Arrange
        HashTable<Date, String> hashTable = new HashTable<Date, String>();
        Date date = new Date(1995, 7, 18);

        // Act
        boolean containsKey = hashTable.containsKey(date);

        // Assert
        Assert.assertFalse(containsKey);
    }

    @Test
    public void Remove_ExistingElement_ShouldWorkCorrectly() {
        // Arrange {{"Peter", 12.5}, {"Maria", 99.9}}
        HashTable<String, Double> hashTable = new HashTable<String, Double>();
        hashTable.add("Peter", 12.5);
        hashTable.add("Maria", 99.9);

        // Assert
        Assert.assertEquals(2, hashTable.size());

        // Act
        boolean removed = hashTable.remove("Peter");

        // Assert
        Assert.assertTrue(removed);
        Assert.assertEquals(1, hashTable.size());
    }

    @Test
    public void Remove_NonExistingElement_ShouldWorkCorrectly() {
        // Arrange
        HashTable<String, Double> hashTable = new HashTable<String, Double>();
        hashTable.add("Peter", 12.5);
        hashTable.add("Maria", 99.9);

        // Assert
        Assert.assertEquals(2, hashTable.size());

        // Act
        boolean removed = hashTable.remove("George");

        // Assert
        Assert.assertFalse(removed);
        Assert.assertEquals(2, hashTable.size());
    }

    @Test
    public void Remove_5000_Elements_ShouldWorkCorrectly() {
        // Arrange
        HashTable<String, Integer> hashTable = new HashTable<String, Integer>();
        List<String> keys = new ArrayList<>();
        int count = 5000;
        for (int i = 0; i < count; i++)
        {
            String key = i + " " + i;
            keys.add(key);
            hashTable.add(key, i);
        }

        // Assert
        Assert.assertEquals(count, hashTable.size());

        // Act & Assert
        for (String key : keys) {
            hashTable.remove(key);
            count--;
            Assert.assertEquals(count, hashTable.size());
        }

//         Assert
        int counter = 0;
        for (KeyValue<String, Integer> stringIntegerKeyValue : hashTable) {
            counter++;
        }

        Assert.assertEquals(0, counter);
    }
}
