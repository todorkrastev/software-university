package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {
    private Shop shop;
    private Goods goods1;
    private Goods goods2;

    @Before
    public void SetUp() {
        this.shop = new Shop();
        this.goods1 = new Goods("Honey", "19");
        this.goods2 = new Goods("Yoghurt", "23");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetShelves() throws OperationNotSupportedException {
        this.shop.addGoods("Shelves1", this.goods1);
        this.shop.getShelves().remove("Shelves1");
        this.shop.getShelves().clear();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsWithNotExistingShelf() throws OperationNotSupportedException {
        this.shop.addGoods("A1", this.goods1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShelfIsAlreadyTaken() throws OperationNotSupportedException {
        this.shop.addGoods("Shelves1", this.goods1);
        this.shop.addGoods("Shelves1", this.goods2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddGoodsGoodsAlreadyInShelf() throws OperationNotSupportedException {
        this.shop.addGoods("Shelves1", this.goods1);
        this.shop.addGoods("Shelves2", this.goods1);
    }

    @Test
    public void testAddGoodsReturnsStringMessage() throws OperationNotSupportedException {
        String expected = "Goods: 19 is placed successfully!";
        String actual = this.shop.addGoods("Shelves1", this.goods1);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsNotExistingShelf() throws OperationNotSupportedException {
        this.shop.addGoods("Shelves1", this.goods1);
        this.shop.removeGoods("A1", goods1);
    }

    @Test(expected =  IllegalArgumentException.class)
    public void testRemoveGoodsNotExistingGoods() throws OperationNotSupportedException {
        this.shop.addGoods("Shelves1", this.goods1);
        this.shop.removeGoods("Shelves1", this.goods2);
    }

    @Test
    public void testRemoveGoods() throws OperationNotSupportedException {
        this.shop.addGoods("Shelves1", this.goods1);
        String actual = this.shop.removeGoods("Shelves1", this.goods1);
        Assert.assertNull(this.shop.getShelves().get("Shelves1"));
        String expected = "Goods: 19 is removed successfully!";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGetName() {
        String actual = this.goods1.getName();
        String expected = "Honey";
        Assert.assertEquals(expected, actual);
    }
}