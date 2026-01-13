package map;

import tiles.Tile;

public abstract class Map {
    abstract Tile createTile();
    public abstract void display();
}
