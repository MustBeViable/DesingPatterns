package map;

import tiles.Tile;

public abstract class Map {
    int maxHeight = 3;
    int maxWidth = 3;

    abstract Tile createTile();

    public void display() {
        for (int i = 0; i < maxHeight; i++) {
            System.out.println();
            for (int j = 0; j < maxWidth; j++) {
                System.out.print(createTile().getCharacter() + " ");
            }
        }
    };
}
