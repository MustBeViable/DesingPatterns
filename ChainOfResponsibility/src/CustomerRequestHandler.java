import entities.Message;
import entities.MessageType;
import handlers.*;

import java.util.Scanner;

public class CustomerRequestHandler {
    private static Scanner scanner = new Scanner(System.in);
    private static Handler claimHandler = new ClaimHandler();
    private static Handler contactHandler = new ContactHandler();
    private static Handler developmentHandler = new DevelopmentHandler();
    private static Handler generalHandler = new GeneralFeedbackHandler();

    public static void main(String[] args) {

        /**
         * Handler chain comensation -> contact -> developement -> general
         */

        Handler startingHandler = claimHandler;

        claimHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(developmentHandler);
        developmentHandler.setNextHandler(generalHandler);

        System.out.println("Please fill report form:");
        System.out.println("Give your email: ");
        String email = scanner.nextLine();
        System.out.println("Please select request type:");
        System.out.println("1. Compensation request");
        System.out.println("2. Contact request");
        System.out.println("3. Developement suggestion");
        System.out.println("4. General feedback and other");

        String type = scanner.nextLine();

        MessageType messageType;

        switch (type) {
            case ("1") -> messageType = MessageType.compensation_claim;
            case ("2") -> messageType = MessageType.contact_request;
            case ("3") -> messageType = MessageType.development_suggestion;
            default -> messageType = MessageType.general_feedback;
        }

        System.out.println("Please write your feedback and press enter to submit: ");

        String content = scanner.nextLine();

        Message message = new Message(messageType, content, email);

        startingHandler.process(message);
    }
}
