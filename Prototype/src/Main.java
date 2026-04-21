import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Recommendation> recommendations = new LinkedHashMap<>();

    public static void main(String[] args) {
        initializeRecommendations();
        runMenu();
    }

    private static void initializeRecommendations() {
        Recommendation horror = new Recommendation("Horror fans", new ArrayList<>());
        horror.addBook(new Book("Stephen King", "The Shining", Genre.HORROR));
        horror.addBook(new Book("Shirley Jackson", "The Haunting of Hill House", Genre.HORROR));

        Recommendation scientific = new Recommendation("Science readers", new ArrayList<>());
        scientific.addBook(new Book("Carl Sagan", "Cosmos", Genre.SCIENTIFIC));
        scientific.addBook(new Book("Stephen Hawking", "A Brief History of Time", Genre.SCIENTIFIC));

        Recommendation history = new Recommendation("History enthusiasts", new ArrayList<>());
        history.addBook(new Book("Yuval Noah Harari", "Sapiens", Genre.HISTORY));
        history.addBook(new Book("Mary Beard", "SPQR", Genre.HISTORY));

        Recommendation romance = new Recommendation("Romance readers", new ArrayList<>());
        romance.addBook(new Book("Jane Austen", "Pride and Prejudice", Genre.ROMANCE));
        romance.addBook(new Book("Nicholas Sparks", "The Notebook", Genre.ROMANCE));

        recommendations.put("horror", horror);
        recommendations.put("scientific", scientific);
        recommendations.put("history", history);
        recommendations.put("romance", romance);
    }

    private static void runMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Book Recommendation System ===");
            System.out.println("1. View recommendation lists");
            System.out.println("2. Add your own recommendation list");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> viewRecommendations();
                case "2" -> addOwnRecommendation();
                case "0" -> {
                    running = false;
                    System.out.println("Exiting program...");
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void viewRecommendations() {
        if (recommendations.isEmpty()) {
            System.out.println("No recommendation lists available.");
            return;
        }

        System.out.println("\n=== Recommendation Lists ===");
        for (Map.Entry<String, Recommendation> entry : recommendations.entrySet()) {
            System.out.println("\nList name: " + entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    private static void addOwnRecommendation() {
        System.out.print("Enter name for your list: ");
        String listName = scanner.nextLine().trim();

        if (recommendations.containsKey(listName)) {
            System.out.println("A list with that name already exists.");
            return;
        }

        System.out.print("Enter target audience: ");
        String audience = scanner.nextLine().trim();

        Recommendation newRecommendation = new Recommendation(audience, new ArrayList<>());

        System.out.print("How many books do you want to add? ");
        int bookCount;

        try {
            bookCount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
            return;
        }

        for (int i = 0; i < bookCount; i++) {
            System.out.println("\nBook " + (i + 1));

            System.out.print("Author: ");
            String author = scanner.nextLine().trim();

            System.out.print("Title: ");
            String title = scanner.nextLine().trim();

            Genre genre = askGenre();

            newRecommendation.addBook(new Book(author, title, genre));
        }

        recommendations.put(listName, newRecommendation);
        System.out.println("Your recommendation list was added.");
    }

    private static Genre askGenre() {
        while (true) {
            System.out.println("Choose genre:");
            System.out.println("1. HORROR");
            System.out.println("2. SCIENTIFIC");
            System.out.println("3. HISTORY");
            System.out.println("4. ROMANCE");
            System.out.print("Your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    return Genre.HORROR;
                case "2":
                    return Genre.SCIENTIFIC;
                case "3":
                    return Genre.HISTORY;
                case "4":
                    return Genre.ROMANCE;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}