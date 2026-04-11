package gui;

import model.map.CityMap;
import model.map.Map;
import model.map.WildernessMap;

import java.util.Scanner;

public class RpgGame {
    public static Map generatedMap;

    private static final int ROWS = 9;
    private static final int COLS = 9;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput;
            do {
                System.out.print("Give a number 1 for city map or 2 for wilderness map.");
                userInput = scanner.nextInt();
                if (userInput != 1 && userInput != 2) {
                    System.out.println("Enter only 1 or 2");
                    continue;
                }
                generatedMap = createMap(userInput);
                generatedMap.generate();
                break;
            } while (true);
        GUI.launch(GUI.class, args);
    }


    public static Map createMap(int mapType) {
        if (mapType == 1) {
            return new CityMap(ROWS, COLS);
        } else if (mapType == 2) {
            return new WildernessMap(ROWS, COLS);
        }
        throw new RuntimeException("Should not do this");
    }
}