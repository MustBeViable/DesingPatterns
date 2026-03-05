package handlers;

import entities.Message;
import entities.MessageType;

import java.util.Random;

public class ClaimHandler extends Handler{
    private Random random = new Random();

    @Override
    public void process(Message message) {
        if (message.getType() == MessageType.compensation_claim) {
            System.out.println("your message: ");
            System.out.println(message.getContent());
            int compensationDecider = random.nextInt(2);
            switch (compensationDecider) {
                case 0 -> System.out.println("Claim rejected");
                case 1 -> System.out.println("Claim approved. Your money will be returned to your payment provider.");
                default -> System.out.println("I think you understood the bound wrong");
            }
        } else {
            super.process(message);
        }
    }
}
