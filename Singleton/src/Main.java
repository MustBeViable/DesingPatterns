import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);

        String fileName = "";
        String data = "";

        while (true) {
            while (fileName.isEmpty()) {
                System.out.println("Give filename (.txt will be added to the end)");
                fileName = scanner.nextLine();

                if (!fileName.isEmpty()) {
                    fileName = fileName + ".txt";
                    logger.setFileName(fileName);
                }
            }

            System.out.println("Write text and enter for new line. Write \"quit\" to quit");
            data = scanner.nextLine();

            if (data.toLowerCase().equals("quit")) {
                logger.close();
                break;
            }

            logger.write(data);
        }
    }
}
