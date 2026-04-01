package model.tiles;

import javafx.scene.image.Image;

import java.util.Objects;

public class BuildingTile extends Tile {

    @Override
    public char getCharacter() {
        return 'B';
    }

    @Override
    public String getType() {
        return "building";
    }

    @Override
    public void action() {

    }
}
