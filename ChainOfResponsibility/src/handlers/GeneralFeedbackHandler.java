package handlers;

import entities.Message;
import entities.MessageType;

public class GeneralFeedbackHandler extends Handler{
    @Override
    public void process(Message message) {
        System.out.println("your message: ");
        System.out.println(message.getContent());
        System.out.println("Feedback have been received. We will contact you via email.");
    }
}
