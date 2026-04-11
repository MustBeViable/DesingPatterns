package model.tiles;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TileGraphicFactory {
    private final Map<String, TileGraphic> cache = new HashMap<>();

    public TileGraphic getGraphic(String tileType) {
        return cache.computeIfAbsent(tileType, this::createGraphic);
    }

    private TileGraphic createGraphic(String tileType) {
        return switch (tileType) {
            case "forest" -> new ForestTileGraphic(loadImage("/tile_assets_bundle/ForestTile/forest_tileset_new_and_old.png"));
            case "road" -> new RoadTileGraphic(loadImage("/tile_assets_bundle/RoadTile/top_down_road_tileset.png"));
            case "water" -> new WaterTileGraphic(loadImage("/tile_assets_bundle/WaterTile/animated_ocean_water_tile.png"));
            case "swamp" -> new SwampTileGraphic(loadImage("/tile_assets_bundle/SwampTile/dead_swamp_tileset.png"));
            case "building" -> new BuildingTileGraphic(loadImage("/tile_assets_bundle/BuildingTile/buildings_top_view.png"));
            default -> throw new IllegalArgumentException("Unknown tile type: " + tileType);
        };
    }

    private Image loadImage(String path) {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)));
    }
}