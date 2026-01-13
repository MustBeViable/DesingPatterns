import map.CityMap;
import map.Map;
import map.WildernessMap;

import java.util.Scanner;

public class Game {

    public void main() {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        do {
            do {
                System.out.print("Give a number 1 for city map or 2 for wilderness map. " +
                        "Give 3 to finish game: ");
                userInput = scanner.nextInt();
                if (userInput != 1 && userInput != 2 && userInput !=3) {
                    System.out.println("Enter only 1, 2 or 3 to exit game");
                }
            } while (userInput != 1 && userInput != 2 && userInput !=3);
            createMap(userInput);
            System.out.println();
        } while (userInput != 3);
    }

    public void createMap(int mapType) {
        Map map;
        if (mapType == 1) {
            map = new CityMap();
            map.display();
        } else if (mapType == 2) {
            map = new WildernessMap();
            map.display();
        }
    }
}
