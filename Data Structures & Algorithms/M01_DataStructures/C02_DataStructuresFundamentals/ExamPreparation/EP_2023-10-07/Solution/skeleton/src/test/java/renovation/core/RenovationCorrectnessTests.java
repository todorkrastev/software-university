package renovation.core;

import renovation.models.Laminate;
import renovation.models.Tile;
import renovation.models.WoodType;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThrows;

public class RenovationCorrectnessTests {

    private Renovation renovationService;

    @Before
    public void setup() {
        this.renovationService = new RenovationImpl();
    }

    @Test
    public void testDeliveredTileAreIncreasesWhenDeliveringTiles() {
        assertThat(this.renovationService.getDeliveredTileArea(), is(0.0));

        Tile t1 = new Tile(2, 2, 0.5);
        Tile t2 = new Tile(3, 3, 0.5);
        this.renovationService.deliverTile(t1);
        this.renovationService.deliverTile(t2);

        assertThat(this.renovationService.getDeliveredTileArea(), is(13.0));
    }

    @Test
    public void testReturnTileThrowsExceptionWhenMissing() {
        Tile t1 = new Tile(2, 2, 0.5);
        Tile t2 = new Tile(3, 3, 0.5);
        this.renovationService.deliverTile(t1);

        assertThrows(IllegalArgumentException.class, () -> this.renovationService.returnTile(t2));
    }

    @Test
    public void testGetAllByWoodType() {
        Laminate l1 = new Laminate(2.2, 0.2, WoodType.OAK);
        Laminate l2 = new Laminate(2.2, 0.3, WoodType.OAK);
        Laminate l3 = new Laminate(2.5, 0.2, WoodType.CHERRY);

        this.renovationService.deliverFlooring(l1);
        this.renovationService.deliverFlooring(l2);
        this.renovationService.deliverFlooring(l3);

        Collection<Laminate> allByWoodType = this.renovationService.getAllByWoodType(WoodType.OAK);

        assertThat(allByWoodType, hasItems(l1, l2));
    }
}
