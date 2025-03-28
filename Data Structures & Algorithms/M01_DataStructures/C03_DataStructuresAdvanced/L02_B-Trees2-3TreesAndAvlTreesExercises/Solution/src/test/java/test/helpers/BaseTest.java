package test.helpers;

import main.IHierarchy;
import org.junit.Before;
import test.HierarchyStructureInitializer;

public class BaseTest {

    protected static final int DefaultRootValue = 5;
    protected IHierarchy<Integer> Hierarchy;

    @Before
    public void setUp() {
        this.Hierarchy = HierarchyStructureInitializer.create(DefaultRootValue);
    }
}
