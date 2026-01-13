package map;

import tiles.BuildingTile;
import tiles.ForestTile;
import tiles.RoadTile;
import tiles.Tile;

import java.util.Random;

public class CityMap extends Map {
    private final Random random = new Random();

    public CityMap(int rows, int cols) {
        super(rows, cols);
    }

    @Override
    Tile createTile() {
        int tile = random.nextInt(3);
        return switch (tile) {
            case 0 -> new ForestTile();
            case 1 -> new BuildingTile();
            case 2 -> new RoadTile();
            default -> throw new RuntimeException("Random gave something else than 0-2");
        };
    }
}
