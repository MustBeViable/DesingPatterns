package gui;

import javafx.scene.canvas.GraphicsContext;
import model.tiles.Tile;
import model.tiles.TileGraphic;
import model.tiles.TileGraphicFactory;

public class MapRenderer {
    private final TileGraphicFactory graphicFactory;
    private final double tileSize;

    public MapRenderer(TileGraphicFactory graphicFactory, double tileSize) {
        this.graphicFactory = graphicFactory;
        this.tileSize = tileSize;
    }

    public void render(GraphicsContext gc, model.map.Map map) {
        Tile[][] tiles = map.getMapTiles();

        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {
                Tile tile = tiles[row][col];
                TileGraphic graphic = graphicFactory.getGraphic(tile.getType());

                double x = col * tileSize;
                double y = row * tileSize;

                graphic.render(gc, x, y, tileSize);
            }
        }
    }
}