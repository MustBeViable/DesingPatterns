package map;

import tiles.Tile;

import java.util.Random;

public abstract class Map {
    private final int rows;
    private final int cols;
    protected Tile[][] tiles;

    protected Map(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Map size must be positive.");
        }
        this.rows = rows;
        this.cols = cols;
        this.tiles = new Tile[rows][cols];
    }

    abstract Tile createTile();

    public void display() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(tiles[r][c].getCharacter());
                if (c < cols - 1) System.out.print(' ');
            }
            System.out.println();
        }
    }

    public void generate() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                tiles[r][c] = createTile();
            }
        }
    }
}
