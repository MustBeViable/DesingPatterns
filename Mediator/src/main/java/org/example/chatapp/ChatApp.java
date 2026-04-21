package org.example.chatapp;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.chatapp.client.ChatClientController;
import org.example.chatapp.mediator.ChatMediator;
import org.example.chatapp.mediator.SimpleChatMediator;

public class ChatApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        ChatMediator mediator = new SimpleChatMediator();

        ChatClientController alice = new ChatClientController("Alice", mediator);
        ChatClientController bob = new ChatClientController("Bob", mediator);
        ChatClientController charlie = new ChatClientController("Charlie", mediator);

        mediator.registerClient(alice);
        mediator.registerClient(bob);
        mediator.registerClient(charlie);

        alice.show();
        bob.show();
        charlie.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}