import entities.Player;

import java.util.Comparator;

public class ListPlayersByScore implements Comparator {
    @Override
    public int compare(Object obj1, Object obj2) {

        Player a = (Player) obj1;
        Player b = (Player) obj2;

        if (a.getScore() < b.getScore()) return -1;
        if (a.getScore() > b.getScore()) return 1;
        return 0;
    }
}
