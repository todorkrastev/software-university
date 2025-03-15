package renovation.core;

import renovation.models.Laminate;
import renovation.models.Tile;
import renovation.models.WoodType;

import java.util.Collection;
import java.util.Iterator;

public interface Renovation {
    void deliverTile(Tile tile);

    void deliverFlooring(Laminate laminate);

    double getDeliveredTileArea();

    boolean isDelivered(Laminate laminate);

    void returnTile(Tile tile);

    void returnLaminate(Laminate laminate);

    Collection<Laminate> getAllByWoodType(WoodType wood);

    Collection<Tile> getAllTilesFitting(double width, double height);

    Collection<Tile> sortTilesBySize();

    Iterator<Laminate> layFlooring();
}
