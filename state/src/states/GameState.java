package states;

import entities.Player;

public abstract class GameState {
    Player player;

    public GameState (Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public abstract String availableActions();

    public abstract String train();

    public abstract String meditate();

    public abstract String fight();

    public abstract Level getLevel();
}
