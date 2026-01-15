package components;

import components.abstracts.Element;
import components.abstracts.UIFactory;
import components.concrete.a.AFactory;
import components.concrete.b.BFactory;

import java.util.Scanner;

public class Main {
    static private boolean stop = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] answer = {'-'};
        do {

            String text = null;

            while (!stop) {
                System.out.println("Do you want A or B structure for UI (A/B)? To end enter q ");
                answer = scanner.nextLine().trim().toUpperCase().toCharArray();
                System.out.println(answer[0]);
                if (answer[0] == 'Q') {
                    stop = true;
                    break;
                }
                if (answer[0] == 'A') {
                    break;
                } else if (answer[0] == 'B') {
                    break;
                } else {
                    System.out.println("Yritit syöttää: " + answer[0]);
                    System.out.println("Only A or B are viable answers.");
                }
            }
            while (!stop) {
                System.out.println("What text do you want to display in components? (3-6 characters). To end enter q");
                text = scanner.nextLine().trim();
                if (text.equals("q") || text.equals("Q")) {
                    stop = true;
                    break;
                }
                if (text.length() >= 2 && text.length() < 7) {
                    break;
                } else {
                    System.out.println("Enter only 3-6 characters. To end enter q");
                }
            }

            UIFactory factory = null;
            Element[] components = null;

            if (!stop) {
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
        } while (!stop);
    }
}
