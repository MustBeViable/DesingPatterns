package handlers;

import entities.Message;
import entities.MessageType;

public class DevelopmentHandler extends Handler{
    @Override
    public void process(Message message) {
        if (message.getType() == MessageType.development_suggestion) {
            System.out.println("your message: ");
            System.out.println(message.getContent());
            System.out.println("Your suggestion have been received. It is forwarded to our user experience team." +
                    " They will contact you shortly via email.");
        } else {
            super.process(message);
        }
    }
}
