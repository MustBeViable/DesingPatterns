package map;

import tiles.*;

import java.util.Random;

public class WildernessMap extends Map {
    private final Random random = new Random();

    public WildernessMap(int rows, int cols) {
        super(rows, cols);
    }

    @Override
    Tile createTile() {

        int tile = random.nextInt(3);
        return switch (tile) {
            case 0 -> new ForestTile();
            case 1 -> new SwampTile();
            case 2 -> new WaterTile();
            default -> throw new RuntimeException("Random gave something else than 0-2");
        };
    }
}

