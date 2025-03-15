package renovation.core;

import renovation.models.Laminate;
import renovation.models.Tile;
import renovation.models.WoodType;

import java.util.*;

public class RenovationImpl implements Renovation {
    private static final double MAX_TILE_AREA = 30.0;
    private double deliveredTileArea = 0.0;
    private final LinkedHashSet<Tile> tileSet = new LinkedHashSet<>();
    private final Deque<Laminate> laminateStack = new ArrayDeque<>();
    private final Set<Laminate> deliveredLaminates = new HashSet<>();

    @Override
    public void deliverTile(Tile tile) {
        double tileArea = tile.getWidth() * tile.getHeight();
        if (deliveredTileArea + tileArea > MAX_TILE_AREA) {
            throw new IllegalArgumentException("Total delivered tile area exceeds 30 sq. m.");
        }
        tileSet.add(tile);
        deliveredTileArea += tileArea;
    }

    @Override
    public void deliverFlooring(Laminate laminate) {
        laminateStack.push(laminate);
        deliveredLaminates.add(laminate);
    }

    @Override
    public double getDeliveredTileArea() {
        return deliveredTileArea;
    }

    @Override
    public boolean isDelivered(Laminate laminate) {
        return deliveredLaminates.contains(laminate);
    }

    @Override
    public void returnTile(Tile tile) {
        if (!tileSet.remove(tile)) {
            throw new IllegalArgumentException("Tile was never delivered.");
        }
        deliveredTileArea -= tile.getWidth() * tile.getHeight();
    }

    @Override
    public void returnLaminate(Laminate laminate) {
        if (!laminateStack.contains(laminate)) {
            throw new IllegalArgumentException("Laminate was never delivered.");
        }
        Deque<Laminate> tempStack = new ArrayDeque<>();
        while (!laminateStack.isEmpty()) {
            Laminate topLaminate = laminateStack.pop();
            if (topLaminate.equals(laminate)) {
                deliveredLaminates.remove(topLaminate);
                break;
            }
            tempStack.push(topLaminate);
        }
        while (!tempStack.isEmpty()) {
            laminateStack.push(tempStack.pop());
        }
    }

    @Override
    public Collection<Laminate> getAllByWoodType(WoodType wood) {
        List<Laminate> result = new ArrayList<>();
        for (Laminate laminate : laminateStack) {
            if (laminate.getWoodType() == wood) {
                result.add(laminate);
            }
        }
        return result;
    }

    @Override
    public Collection<Tile> getAllTilesFitting(double width, double height) {
        List<Tile> result = new ArrayList<>();
        for (Tile tile : tileSet) {
            if (tile.getWidth() <= width && tile.getHeight() <= height) {
                result.add(tile);
            }
        }
        return result;
    }

    @Override
    public Collection<Tile> sortTilesBySize() {
        List<Tile> sortedTiles = new ArrayList<>(tileSet);
        sortedTiles.sort(Comparator.comparingDouble((Tile t) -> t.getWidth() * t.getHeight())
                .thenComparingDouble(Tile::getDepth));
        return sortedTiles;
    }

    @Override
    public Iterator<Laminate> layFlooring() {
        return laminateStack.iterator();
    }
}