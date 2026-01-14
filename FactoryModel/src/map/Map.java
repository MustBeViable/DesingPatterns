package map;

import tiles.Tile;

public abstract class Map {
    private final int ROWS;
    private final int COLS;
    protected Tile[][] tiles;

    protected Map(int ROWS, int COLS) {
        if (ROWS <= 0 || COLS <= 0) {
            throw new IllegalArgumentException("Map size must be positive.");
        }
        this.ROWS = ROWS;
        this.COLS = COLS;
        this.tiles = new Tile[ROWS][COLS];
    }

    abstract Tile createTile();

    public void display() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                System.out.print(tiles[r][c].getCharacter());
                if (c < COLS - 1) System.out.print(' ');
            }
            System.out.println();
        }
    }

    public void generate() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                tiles[r][c] = createTile();
            }
        }
    }
}
