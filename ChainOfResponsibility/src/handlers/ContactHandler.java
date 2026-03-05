package handlers;

import entities.Message;
import entities.MessageType;

public class ContactHandler extends Handler{
    @Override
    public void process(Message message) {
        if (message.getType() == MessageType.contact_request) {
            System.out.println("your message: ");
            System.out.println(message.getContent());
            System.out.println("Your contact request have been received. We will contact you as soon as possible " +
                    "via your given email.");
        } else {
            super.process(message);
        }
    }
}
