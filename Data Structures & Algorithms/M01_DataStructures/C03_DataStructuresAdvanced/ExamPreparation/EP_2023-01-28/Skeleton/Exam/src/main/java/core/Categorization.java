package core;

import models.Category;

public interface Categorization {
    void addCategory(Category category);

    void assignParent(String childCategoryId, String parentCategoryId);

    void removeCategory(String categoryId);

    boolean contains(Category category);

    int size();

    Iterable<Category> getChildren(String categoryId);

    Iterable<Category> getHierarchy(String categoryId);

    Iterable<Category> getTop3CategoriesOrderedByDepthOfChildrenThenByName();
}
