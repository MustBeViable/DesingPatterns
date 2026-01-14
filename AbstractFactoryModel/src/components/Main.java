package components;

import components.abstracts.Element;
import components.abstracts.UIFactory;
import components.concrete.a.AFactory;
import components.concrete.b.BFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[] answer;
        String text = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Do you want A or B structure for UI (A/B)?");
            answer = scanner.nextLine().trim().toUpperCase().toCharArray();
            if (answer[0] == 'A') {
                break;
            } else if (answer[0] == 'B') {
                break;
            } else {
                System.out.println("Yritit syöttää: " + answer[0]);
                System.out.println("Only A or B are viable answers.");
            }
        }
        while (true) {
            System.out.println("What text do you want to display in components? (3-6 characters)");
            text = scanner.nextLine().trim();
            if (text.length() >= 2 && text.length() < 7) {
                break;
            }
            else {
                System.out.println("Enter only 3-6 characters");
            }
        }

        UIFactory factory = null;
        Element[] components = null;

        switch (answer[0]) {
            case 'A' -> {
                factory = new AFactory();
                components = factory.generate(text);
            }
            case 'B' -> {
                factory = new BFactory();
                components = factory.generate(text);
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println();
            components[i].display();
            System.out.println();
        }
    }
}
