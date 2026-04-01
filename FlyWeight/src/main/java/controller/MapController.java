package controller;

import javafx.scene.image.Image;
import model.map.Map;

import java.util.Objects;

public class MapController {
    private final Image buildingTileImage =
            new Image(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/tile_assets_bundle/BuildingTile/buildings_top_view.png")));

    private final Image forestTileImage =
            new Image(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/tile_assets_bundle/ForestTile/forest_tileset_new_and_old.png")));

    private final Image roadTileImage =
            new Image(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/tile_assets_bundle/RoadTile/top_down_road_tileset.png")));

    private final Image swampTileImage =
            new Image(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/tile_assets_bundle/SwampTile/dead_swamp_tileset.png")));

    private final Image swampWaterTileImage =
            new Image(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/tile_assets_bundle/SwampTile/dead_swamp_animated_water.png")));

    private final Image waterTileImage =
            new Image(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/tile_assets_bundle/WaterTile/animated_ocean_water_tile.png")));

    private final Map map;

    public MapController(Map map) {
        this.map = map;
    }
}