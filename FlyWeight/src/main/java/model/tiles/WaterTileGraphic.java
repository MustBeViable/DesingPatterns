package model.tiles;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class WaterTileGraphic implements TileGraphic{

    private final Image sprite;

    public WaterTileGraphic(Image sprite) {
        this.sprite = sprite;
    }

    @Override
    public void render(GraphicsContext gc, double x, double y, double tileSize) {
        gc.drawImage(sprite, x, y, tileSize, tileSize);
    }
}
