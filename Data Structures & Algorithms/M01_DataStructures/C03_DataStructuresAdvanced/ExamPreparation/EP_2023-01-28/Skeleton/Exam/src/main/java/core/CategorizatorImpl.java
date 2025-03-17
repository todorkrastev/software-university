package core;

import models.Category;

public class CategorizatorImpl implements Categorizator {

    @Override
    public void addCategory(Category category) {

    }

    @Override
    public void assignParent(String childCategoryId, String parentCategoryId) {

    }

    @Override
    public void removeCategory(String categoryId) {

    }

    @Override
    public boolean contains(Category category) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<Category> getChildren(String categoryId) {
        return null;
    }

    @Override
    public Iterable<Category> getHierarchy(String categoryId) {
        return null;
    }

    @Override
    public Iterable<Category> getTop3CategoriesOrderedByDepthOfChildrenThenByName() {
        return null;
    }
}
