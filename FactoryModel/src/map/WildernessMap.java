package map;

import tiles.*;

import java.util.Random;

public class WildernessMap extends Map {

    Random random = new Random();
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

