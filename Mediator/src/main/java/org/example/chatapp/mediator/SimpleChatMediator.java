package org.example.chatapp.mediator;

import org.example.chatapp.client.ChatClientController;

import java.util.HashMap;
import java.util.Map;

public class SimpleChatMediator implements ChatMediator {

    private final Map<String, ChatClientController> clients = new HashMap<>();

    @Override
    public void registerClient(ChatClientController client) {
        clients.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String from, String to, String message) {
        ChatClientController sender = clients.get(from);
        ChatClientController receiver = clients.get(to);

        if (sender == null || receiver == null) {
            return;
        }

        // Näytä lähettäjälle oma viesti
        sender.receiveSystemMessage("You -> " + to + ": " + message);

        // Näytä vastaanottajalle saatu viesti
        receiver.receiveMessage(from, message);
    }
}