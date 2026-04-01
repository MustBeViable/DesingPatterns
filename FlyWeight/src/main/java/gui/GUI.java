package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;

public class GUI extends Application {
    final Canvas canvas = new Canvas();


    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 10000.0, 800.0);
        stage.setScene(scene);
        stage.show();
    }
}
