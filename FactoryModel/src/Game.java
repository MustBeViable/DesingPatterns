import map.CityMap;
import map.Map;
import map.WildernessMap;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        Map map = null;
        do {
            do {
                System.out.print("Give a number 1 for city map or 2 for wilderness map. " +
                        "Give 3 to finish game: ");
                userInput = scanner.nextInt();
                if (userInput != 1 && userInput != 2 && userInput !=3) {
                    System.out.println("Enter only 1, 2 or 3 to exit game");
                    continue;
                }
                if (userInput == 1 || userInput == 2) {
                    map = createMap(userInput);
                    map.generate();
                }
            } while (userInput != 1 && userInput != 2 && userInput !=3);
            map.display();
            System.out.println();
        } while (userInput != 3);
    }

    public static Map createMap(int mapType) {
        if (mapType == 1) {
            return new CityMap(3,3);
        } else if (mapType == 2) {
            return new WildernessMap(3,3);
        }
        throw new RuntimeException("Should not do this");
    }
}
