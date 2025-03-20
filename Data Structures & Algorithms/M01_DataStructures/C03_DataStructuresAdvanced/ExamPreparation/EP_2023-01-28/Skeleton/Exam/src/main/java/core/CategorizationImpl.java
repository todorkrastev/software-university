package core;

import models.Category;

import java.util.*;
import java.util.stream.Collectors;

public class CategorizationImpl implements Categorization {

    private final Map<String, Category> categoriesById;
    private final Map<String, Category> parentByCatId;
    private final Map<String, LinkedHashSet<Category>> childrenByCatId;
    private final Map<String, Long> depthByCatId;

    public CategorizationImpl() {
        this.categoriesById = new LinkedHashMap<>();
        this.parentByCatId = new HashMap<>();
        this.childrenByCatId = new HashMap<>();
        this.depthByCatId = new HashMap<>();
    }

    @Override
    public void addCategory(Category category) {
        if (contains(category)) {
            throw new IllegalArgumentException("Category already exists");
        }

        categoriesById.put(category.getId(), category);
        childrenByCatId.put(category.getId(), new LinkedHashSet<>());
    }

    @Override
    public void assignParent(String childCategoryId, String parentCategoryId) {
        Category child = tryGetCategory(childCategoryId);
        Category parent = tryGetCategory(parentCategoryId);

        if (child == null || parent == null) {
            throw new IllegalArgumentException("Category not found");
        }

        Category previousParent = parentByCatId.put(child.getId(), parent);
        if (previousParent == parent) {
            throw new IllegalArgumentException("Category already has this parent");
        }

        LinkedHashSet<Category> parentCategoryChildren = childrenByCatId.get(parent.getId());
        parentCategoryChildren.add(child);
    }

    @Override
    public void removeCategory(String categoryId) {
        Category categoryToDelete = categoriesById.remove(categoryId);
        if (categoryToDelete == null) {
            throw new IllegalArgumentException("Category not found");
        }

        LinkedHashSet<Category> childrenToDelete = new LinkedHashSet<>(childrenByCatId.get(categoryToDelete.getId()));
        for (Category category : childrenToDelete) {
            removeCategory(category.getId());
        }

        Category parent = parentByCatId.remove(categoryToDelete.getId());
        if (parent != null) {
            LinkedHashSet<Category> parentCategoryChildren = childrenByCatId.get(parent.getId());
            parentCategoryChildren.remove(categoryToDelete);
        }

    }

    @Override
    public boolean contains(Category category) {
        return contains(category.getId());
    }

    @Override
    public int size() {
        return categoriesById.size();
    }

    @Override
    public Iterable<Category> getChildren(String categoryId) {
        if (!contains(categoryId)) {
            throw new IllegalArgumentException("Category not found");
        }

        ArrayList<Category> allChildren = new ArrayList<>();
        fillChildren(categoryId, allChildren);

        return allChildren;
    }

    @Override
    public Iterable<Category> getHierarchy(String categoryId) {
        Category category = tryGetCategory(categoryId);
        if (category == null) {
            throw new IllegalArgumentException("Category not found");
        }

        List<Category> hierarchy = new ArrayList<>();
        while (category != null) {
            hierarchy.add(category);
            category = parentByCatId.get(category.getId());
        }

        Collections.reverse(hierarchy);
        return hierarchy;
    }

    @Override
    public Iterable<Category> getTop3CategoriesOrderedByDepthOfChildrenThenByName() {
        for (Category category : categoriesById.values()) {
            if (parentByCatId.get(category.getId()) == null) {
                calculateDepth(category);
            }
        }

        return categoriesById.values().stream()
                .sorted(Comparator.comparing(
                                (Category c) -> depthByCatId.get(c.getId()), Comparator.reverseOrder())
                        .thenComparing(Category::getName)
                )
                .limit(3)
                .collect(Collectors.toList());
    }

    private long calculateDepth(Category category) {
        long maxChildDepth = 0;

        for (Category childCategory : childrenByCatId.get(category.getId())) {
            long childDepth = calculateDepth(childCategory);
            if (childDepth > maxChildDepth) {
                maxChildDepth = childDepth;
            }
        }

        long depth = 1 + maxChildDepth;
        depthByCatId.put(category.getId(), depth);

        return depth;
    }

    private void fillChildren(String categoryId, List<Category> allChildren) {
        LinkedHashSet<Category> directChildren = childrenByCatId.get(categoryId);
        for (Category directChild : directChildren) {
            allChildren.add(directChild);
            fillChildren(directChild.getId(), allChildren);
        }
    }

    private boolean contains(String categoryId) {
        return tryGetCategory(categoryId) != null;
    }

    private Category tryGetCategory(String id) {
        return categoriesById.get(id);
    }
}