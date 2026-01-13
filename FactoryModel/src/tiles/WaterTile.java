package tiles;

public class WaterTile extends Tile {
    @Override
    public char getCharacter() {
        return 'W';
    }

    @Override
    String getType() {
        return "water";
    }

    @Override
    void action() {

    }
}
