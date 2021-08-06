package bankSafe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class BankVaultTest {

    private static final String owner1 = "Todor";
    private static final String owner2 = "Dominique";
    private static final String itemId1 = "19";
    private static final String itemId2 = "23";
    private static Item item1;
    private static Item item2;
    private static final String testInvalidCeil = "Z1";
    private static final String testValidCeil1 = "A1";
    private static final String testValidCeil2 = "A2";
    private static BankVault testBankVault;
    private static String expected = "";

    @Before
    public void setUp() {
        item1 = createItem(owner1, itemId1);
        item2 = createItem(owner2, itemId2);
        testBankVault = new BankVault();
        Main.main(new String[]{"", ""});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemMustFailsWhenGetInvalidCeilName() throws OperationNotSupportedException {
        testBankVault.addItem(testInvalidCeil, item1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemMustFailsWhenGetAlReadyTakenCeil() throws OperationNotSupportedException {
        testBankVault.addItem(testValidCeil1, item1);
        testBankVault.addItem(testValidCeil1, item2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddItemMustFailsWhenItemIsAlreadyInCeil() throws OperationNotSupportedException {
        testBankVault.addItem(testValidCeil1, item1);
        testBankVault.addItem(testValidCeil2, item1);
    }

    @Test
    public void testAddItemMustAddCorrectItem() throws OperationNotSupportedException {
        expected = String.format("Item:%s saved successfully!", itemId1);
        Assert.assertEquals(expected, testBankVault.addItem(testValidCeil1, item1));
        Assert.assertEquals(item1, testBankVault.getVaultCells().get(testValidCeil1));
        Assert.assertEquals(owner1, testBankVault.getVaultCells().get(testValidCeil1).getOwner());
        Assert.assertEquals(itemId1, testBankVault.getVaultCells().get(testValidCeil1).getItemId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveMustFailsWhenGetInvalidCeil() throws OperationNotSupportedException {
        testBankVault.addItem(testValidCeil1, item1);
        testBankVault.removeItem(testInvalidCeil, item1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveMustFailsWhenGetInvalidItem() throws OperationNotSupportedException {
        testBankVault.addItem(testValidCeil1, item1);
        testBankVault.removeItem(testValidCeil1, item2);
    }

    @Test
    public void testRemoveMustRemoveCorrectItem() throws OperationNotSupportedException {
        testBankVault.addItem(testValidCeil1, item1);
        expected = String.format("Remove item:%s successfully!", itemId1);
        Assert.assertEquals(expected, testBankVault.removeItem(testValidCeil1, item1));
        Assert.assertNull(testBankVault.getVaultCells().get(testValidCeil1));
    }

    private Item createItem(String owner, String itemId) {
        return new Item(owner, itemId);
    }
}