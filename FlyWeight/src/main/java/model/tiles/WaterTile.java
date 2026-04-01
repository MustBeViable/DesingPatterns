package model.tiles;

import javafx.scene.image.Image;

public class WaterTile extends Tile {

    @Override
    public char getCharacter() {
        return 'W';
    }

    @Override
    public String getType() {
        return "water";
    }

    @Override
    public void action() {

    }
}
