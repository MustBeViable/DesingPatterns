package org.example.chatapp.client;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.chatapp.mediator.ChatMediator;

public class ChatClientController {

    private final String username;
    private final ChatMediator mediator;
    private final Stage stage;

    private final TextArea chatArea;
    private final TextField messageField;
    private final TextField recipientField;
    private final Button sendButton;

    public ChatClientController(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        this.stage = new Stage();

        this.chatArea = new TextArea();
        this.messageField = new TextField();
        this.recipientField = new TextField();
        this.sendButton = new Button("Send");

        buildUI();
        setupActions();
    }

    private void buildUI() {
        stage.setTitle("Chat Client - " + username);

        chatArea.setEditable(false);
        chatArea.setPrefHeight(300);

        recipientField.setPromptText("Recipient username");
        messageField.setPromptText("Type your message here");

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(
                new Label("Messages"),
                chatArea,
                new Label("Recipient"),
                recipientField,
                new Label("Message"),
                messageField,
                sendButton
        );

        Scene scene = new Scene(root, 400, 450);
        stage.setScene(scene);
    }

    private void setupActions() {
        sendButton.setOnAction(e -> sendMessage());

        messageField.setOnAction(e -> sendMessage());
    }

    private void sendMessage() {
        String recipient = recipientField.getText().trim();
        String message = messageField.getText().trim();

        if (recipient.isEmpty() || message.isEmpty()) {
            receiveSystemMessage("Recipient and message must not be empty.");
            return;
        }

        mediator.sendMessage(username, recipient, message);
        messageField.clear();
    }

    public void receiveMessage(String from, String message) {
        chatArea.appendText(from + " -> You: " + message + "\n");
    }

    public void receiveSystemMessage(String message) {
        chatArea.appendText("[System] " + message + "\n");
    }

    public String getUsername() {
        return username;
    }

    public void show() {
        stage.show();
    }
}