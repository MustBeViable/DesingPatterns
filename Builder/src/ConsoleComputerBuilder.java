import java.util.Locale;
import java.util.Scanner;

public class ConsoleComputerBuilder {
    public static void main(String[] args) {
        ComputerBuilder computerBuilder;
        ComputerDirector director = new ComputerDirector();
        Computer computer;
        Scanner scanner = new Scanner(System.in);
        int answer = 0;
        do {
            System.out.println("1. Office computer, 2. Gaming computer: ");
            try {
                answer = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Give 1 or 2");
            }
            if (answer == 1) {
                computerBuilder = new OfficeComputerBuilder();
                director.constructComputer(computerBuilder);
                computer = computerBuilder.getComputer();
                computer.getComputerInfo();
                break;
            } else if (answer == 2) {
                computerBuilder = new GamingComputerBuilder();
                director.constructComputer(computerBuilder);
                computer = computerBuilder.getComputer();
                computer.getComputerInfo();
                break;
            } else {
                System.out.println("Give a valid answer");
            }
        } while (true);
    }
}
