package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.tiles.TileGraphicFactory;


public class GUI extends Application {


    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(576, 576);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        TileGraphicFactory factory = new TileGraphicFactory();
        MapRenderer renderer = new MapRenderer(factory, 64);

        renderer.render(gc, RpgGame.generatedMap);

        Pane root = new Pane(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
