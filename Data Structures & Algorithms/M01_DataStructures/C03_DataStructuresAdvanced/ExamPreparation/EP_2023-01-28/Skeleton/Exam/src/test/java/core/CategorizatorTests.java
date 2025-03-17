package core;

import models.Category;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class CategorizatorTests {
    private interface InternalTest {
        void execute();
    }

    private Categorizator categorizator;

    private Category getRandomCategory() {
        return new Category(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString());
    }

    @Before
    public void setup() {
        this.categorizator = new CategorizatorImpl();
    }

    public void performCorrectnessTesting(InternalTest[] methods) {
        Arrays.stream(methods)
                .forEach(method -> {
                    this.categorizator = new CategorizatorImpl();

                    try {
                        method.execute();
                    } catch (IllegalArgumentException ignored) { }
                });

        this.categorizator = new CategorizatorImpl();
    }

    // Correctness Tests

    @Test
    public void testSize_ShouldReturnCorrectResults() {
        this.categorizator.addCategory(getRandomCategory());
        this.categorizator.addCategory(getRandomCategory());
        this.categorizator.addCategory(getRandomCategory());

        assertEquals(this.categorizator.size(), 3);
    }

    @Test
    public void testAddCategory_WithDuplicate_ShouldThrow() {
        Category category = this.getRandomCategory();
        this.categorizator.addCategory(category);

        // Little bit of hacks
        try {
            this.categorizator.addCategory(category);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
            return;
        }

        assertTrue(false);
    }

    @Test
    public void testContains_WithExistentCategory_ShouldReturnTrue() {
        Category category = getRandomCategory();
        this.categorizator.addCategory(category);

        assertTrue(this.categorizator.contains(category));
    }

    @Test
    public void testContains_WithNonExistentCategory_ShouldReturnFalse() {
        Category category = getRandomCategory();
        this.categorizator.addCategory(category);

        assertFalse(this.categorizator.contains(getRandomCategory()));
    }

    @Test
    public void testAssignParent_WithDuplicateCategories_ShouldReturnCorrectResults() {
        Category childCategory = getRandomCategory();
        Category parentCategory = getRandomCategory();
        this.categorizator.addCategory(childCategory);
        this.categorizator.addCategory(parentCategory);

        this.categorizator.assignParent(childCategory.getId(), parentCategory.getId());

        // Little bit of hacks
        try {
            this.categorizator.assignParent(childCategory.getId(), parentCategory.getId());
        } catch (IllegalArgumentException e) {
            assertTrue(true);
            return;
        }

        assertTrue(false);
    }

    // Performance Tests

    @Test
    public void testContains_With100000Results_ShouldPassQuickly() {
        this.performCorrectnessTesting(new InternalTest[] {
                this::testContains_WithExistentCategory_ShouldReturnTrue,
                this::testContains_WithNonExistentCategory_ShouldReturnFalse,
        });

        int count = 100000;

        Category categoryToContain = null;

        for (int i = 0; i < count; i++)
        {
            if(i == count / 2) {
                categoryToContain = getRandomCategory();
                this.categorizator.addCategory(categoryToContain);
            } else {
                this.categorizator.addCategory(getRandomCategory());
            }
        }

        long start = System.currentTimeMillis();

        this.categorizator.contains(categoryToContain);

        long stop = System.currentTimeMillis();

        long elapsedTime = stop - start;

        assertTrue(elapsedTime <= 5);
    }
}
