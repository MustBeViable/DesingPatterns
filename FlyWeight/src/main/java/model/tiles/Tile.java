package model.tiles;

import javafx.scene.image.Image;

public abstract class Tile {
    public abstract char getCharacter();
    public abstract String getType();
    public abstract void action();
}
