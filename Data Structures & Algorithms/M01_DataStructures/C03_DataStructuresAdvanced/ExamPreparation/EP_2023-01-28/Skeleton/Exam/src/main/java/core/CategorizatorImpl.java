package core;

import models.Category;

import java.util.*;
import java.util.stream.Collectors;

public class CategorizatorImpl implements Categorizator {

    private Map<String, Category> categoriesById;
    private Map<String, Set<String>> parentToChildren;
    private Map<String, String> childToParent;

    public CategorizatorImpl() {
        this.categoriesById = new HashMap<>();
        this.parentToChildren = new HashMap<>();
        this.childToParent = new HashMap<>();
    }

    @Override
    public void addCategory(Category category) {
        if (categoriesById.containsKey(category.getId())) {
            throw new IllegalArgumentException("Category already exists");
        }
        categoriesById.put(category.getId(), category);
    }

    @Override
    public void assignParent(String childCategoryId, String parentCategoryId) {
        if (!categoriesById.containsKey(childCategoryId) || !categoriesById.containsKey(parentCategoryId)) {
            throw new IllegalArgumentException("Category not found");
        }
        if (childToParent.containsKey(childCategoryId) && childToParent.get(childCategoryId).equals(parentCategoryId)) {
            throw new IllegalArgumentException("Child category already assigned to this parent");
        }
        childToParent.put(childCategoryId, parentCategoryId);
        parentToChildren.computeIfAbsent(parentCategoryId, k -> new HashSet<>()).add(childCategoryId);
    }

    @Override
    public void removeCategory(String categoryId) {
        if (!categoriesById.containsKey(categoryId)) {
            throw new IllegalArgumentException("Category not found");
        }
        removeCategoryAndChildren(categoryId);
    }

    private void removeCategoryAndChildren(String categoryId) {
        Set<String> children = parentToChildren.getOrDefault(categoryId, new HashSet<>());
        for (String childId : children) {
            removeCategoryAndChildren(childId);
        }
        categoriesById.remove(categoryId);
        parentToChildren.remove(categoryId);
        childToParent.remove(categoryId);
    }

    @Override
    public boolean contains(Category category) {
        return categoriesById.containsKey(category.getId());
    }

    @Override
    public int size() {
        return categoriesById.size();
    }

    @Override
    public Iterable<Category> getChildren(String categoryId) {
        if (!categoriesById.containsKey(categoryId)) {
            throw new IllegalArgumentException("Category not found");
        }
        List<Category> result = new ArrayList<>();
        getChildrenRecursive(categoryId, result);
        return result;
    }

    private void getChildrenRecursive(String categoryId, List<Category> result) {
        Set<String> children = parentToChildren.getOrDefault(categoryId, new HashSet<>());
        for (String childId : children) {
            result.add(categoriesById.get(childId));
            getChildrenRecursive(childId, result);
        }
    }

    @Override
    public Iterable<Category> getHierarchy(String categoryId) {
        if (!categoriesById.containsKey(categoryId)) {
            throw new IllegalArgumentException("Category not found");
        }
        List<Category> hierarchy = new ArrayList<>();
        String currentId = categoryId;
        while (currentId != null) {
            hierarchy.add(categoriesById.get(currentId));
            currentId = childToParent.get(currentId);
        }
        Collections.reverse(hierarchy);
        return hierarchy;
    }

    @Override
    public Iterable<Category> getTop3CategoriesOrderedByDepthOfChildrenThenByName() {
        return categoriesById.values().stream()
                .sorted(Comparator.comparingInt(this::getDepthOfChildren).reversed()
                        .thenComparing(Category::getName))
                .limit(3)
                .collect(Collectors.toList());
    }

    private int getDepthOfChildren(Category category) {
        return getDepthRecursive(category.getId());
    }

    private int getDepthRecursive(String categoryId) {
        Set<String> children = parentToChildren.getOrDefault(categoryId, new HashSet<>());
        if (children.isEmpty()) {
            return 0;
        }
        int maxDepth = 0;
        for (String childId : children) {
            maxDepth = Math.max(maxDepth, getDepthRecursive(childId));
        }
        return maxDepth + 1;
    }
}