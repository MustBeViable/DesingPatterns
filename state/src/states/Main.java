package states;

import entities.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give name to your character: ");
        String name = scanner.nextLine().trim();
        Long start = System.currentTimeMillis();
        new Player(name, scanner).play();
        Long end = System.currentTimeMillis();
        double time = (double) (end - start)/1000;
        System.out.println("Your playtime was: " + time + "s");
    }
}
