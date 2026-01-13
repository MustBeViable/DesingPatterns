package tiles;

public class RoadTile extends Tile {
    @Override
    public char getCharacter() {
        return 'R';
    }

    @Override
    String getType() {
        return "road";
    }

    @Override
    void action() {

    }
}
