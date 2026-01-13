package tiles;

public class SwampTile extends Tile {
    @Override
    public char getCharacter() {
        return 'S';
    }

    @Override
    String getType() {
        return "swamp";
    }

    @Override
    void action() {

    }
}
