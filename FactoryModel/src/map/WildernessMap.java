package map;

import tiles.*;

import java.util.Random;

public class WildernessMap extends Map {
    int maxHeight = 3;
    int maxWidth = 3;
    Random random = new Random();
    @Override
    Tile createTile() {

        int tile = random.nextInt(0,3);
        return switch (tile) {
            case 0 -> new ForestTile();
            case 1 -> new SwampTile();
            case 2 -> new WaterTile();
            default -> throw new RuntimeException("Random gave something else than 0-2");
        };
    }

    @Override
    public void display() {
        for (int i = 0; i < maxHeight; i++) {
            System.out.println();
            for (int j = 0; j < maxWidth; j++) {
                System.out.print(createTile().getCharacter() + " ");
            }
        }
    }
}

