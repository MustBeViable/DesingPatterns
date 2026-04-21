package org.example.chatapp.mediator;

import org.example.chatapp.client.ChatClientController;

public interface ChatMediator {
    void registerClient(ChatClientController client);
    void sendMessage(String from, String to, String message);
}