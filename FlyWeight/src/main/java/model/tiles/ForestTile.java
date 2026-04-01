package model.tiles;

import javafx.scene.image.Image;

import java.util.Objects;

public class ForestTile extends Tile {
    @Override
    public char getCharacter() {
        return 'F';
    }

    @Override
    public String getType() {
        return "forest";
    }

    @Override
    public void action() {

    }
}
