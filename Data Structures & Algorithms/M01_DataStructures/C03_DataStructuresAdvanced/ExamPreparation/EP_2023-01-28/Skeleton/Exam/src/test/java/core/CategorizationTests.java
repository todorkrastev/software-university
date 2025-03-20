package core;

import models.Category;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

public class CategorizationTests {
    private interface InternalTest {
        void execute();
    }

    private Categorization categorization;

    private Category getRandomCategory() {
        return new Category(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString());
    }

    @Before
    public void setup() {
        this.categorization = new CategorizationImpl();
    }

    public void performCorrectnessTesting(InternalTest[] methods) {
        Arrays.stream(methods)
                .forEach(method -> {
                    this.categorization = new CategorizationImpl();

                    try {
                        method.execute();
                    } catch (IllegalArgumentException ignored) { }
                });

        this.categorization = new CategorizationImpl();
    }

    // Correctness Tests

    @Test
    public void testSize_ShouldReturnCorrectResults() {
        this.categorization.addCategory(getRandomCategory());
        this.categorization.addCategory(getRandomCategory());
        this.categorization.addCategory(getRandomCategory());

        assertEquals(this.categorization.size(), 3);
    }

    @Test
    public void testAddCategory_WithDuplicate_ShouldThrow() {
        Category category = this.getRandomCategory();
        this.categorization.addCategory(category);

        try {
            this.categorization.addCategory(category);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
            return;
        }

        assertTrue(false);
    }

    @Test
    public void testContains_WithExistentCategory_ShouldReturnTrue() {
        Category category = getRandomCategory();
        this.categorization.addCategory(category);

        assertTrue(this.categorization.contains(category));
    }

    @Test
    public void testContains_WithNonExistentCategory_ShouldReturnFalse() {
        Category category = getRandomCategory();
        this.categorization.addCategory(category);

        assertFalse(this.categorization.contains(getRandomCategory()));
    }

    @Test
    public void testAssignParent_WithDuplicateCategories_ShouldReturnCorrectResults() {
        Category childCategory = getRandomCategory();
        Category parentCategory = getRandomCategory();
        this.categorization.addCategory(childCategory);
        this.categorization.addCategory(parentCategory);

        this.categorization.assignParent(childCategory.getId(), parentCategory.getId());

        try {
            this.categorization.assignParent(childCategory.getId(), parentCategory.getId());
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
                this.categorization.addCategory(categoryToContain);
            } else {
                this.categorization.addCategory(getRandomCategory());
            }
        }

        long start = System.currentTimeMillis();

        this.categorization.contains(categoryToContain);

        long stop = System.currentTimeMillis();

        long elapsedTime = stop - start;

        assertTrue(elapsedTime <= 5);
    }

    @Test
    public void testGetChildren_WithValidCategory_ShouldReturnCorrectChildren() {
        Category parent = getRandomCategory();
        Category child1 = getRandomCategory();
        Category child2 = getRandomCategory();
        this.categorization.addCategory(parent);
        this.categorization.addCategory(child1);
        this.categorization.addCategory(child2);
        this.categorization.assignParent(child1.getId(), parent.getId());
        this.categorization.assignParent(child2.getId(), parent.getId());

        Iterable<Category> children = this.categorization.getChildren(parent.getId());
        List<Category> childrenList = new ArrayList<>();
        children.forEach(childrenList::add);

        assertEquals(2, childrenList.size());
        assertTrue(childrenList.contains(child1));
        assertTrue(childrenList.contains(child2));
    }

    @Test
    public void testGetHierarchy_WithValidCategory_ShouldReturnCorrectHierarchy() {
        Category grandparent = getRandomCategory();
        Category parent = getRandomCategory();
        Category child = getRandomCategory();
        this.categorization.addCategory(grandparent);
        this.categorization.addCategory(parent);
        this.categorization.addCategory(child);
        this.categorization.assignParent(parent.getId(), grandparent.getId());
        this.categorization.assignParent(child.getId(), parent.getId());

        Iterable<Category> hierarchy = this.categorization.getHierarchy(child.getId());
        List<Category> hierarchyList = new ArrayList<>();
        hierarchy.forEach(hierarchyList::add);

        assertEquals(3, hierarchyList.size());
        assertEquals(grandparent, hierarchyList.get(0));
        assertEquals(parent, hierarchyList.get(1));
        assertEquals(child, hierarchyList.get(2));
    }

    @Test
    public void testGetTop3CategoriesOrderedByDepthOfChildrenThenByName_ShouldReturnCorrectCategories() {
        Category category1 = new Category("1", "A", "desc");
        Category category2 = new Category("2", "B", "desc");
        Category category3 = new Category("3", "C", "desc");
        Category category4 = new Category("4", "D", "desc");
        Category category5 = new Category("5", "E", "desc");

        this.categorization.addCategory(category1);
        this.categorization.addCategory(category2);
        this.categorization.addCategory(category3);
        this.categorization.addCategory(category4);
        this.categorization.addCategory(category5);

        this.categorization.assignParent("2", "1");
        this.categorization.assignParent("3", "1");
        this.categorization.assignParent("4", "2");
        this.categorization.assignParent("5", "2");

        Iterable<Category> top3Categories = this.categorization.getTop3CategoriesOrderedByDepthOfChildrenThenByName();
        List<Category> top3List = new ArrayList<>();
        top3Categories.forEach(top3List::add);

        assertEquals(3, top3List.size());
        assertEquals(category1, top3List.get(0));
        assertEquals(category2, top3List.get(1));
        assertEquals(category3, top3List.get(2));
    }
}
