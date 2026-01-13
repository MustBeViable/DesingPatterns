package tiles;

public class BuildingTile extends Tile {
    @Override
    public char getCharacter() {
        return 'B';
    }

    @Override
    String getType() {
        return "building";
    }

    @Override
    void action() {

    }
}
