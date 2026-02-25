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

    public boolean checkGame() {

        if (this.isDead()) {
            System.out.println("You died.");
            return this.isDead();
        }
        if (this.gameWon()) {
            System.out.println("You won.");
            return this.gameWon();
        }
        else return false;
    }

    public boolean isDead() {
        return player.getHp() <= 0;
    }

    public boolean gameWon() {
        return player.getHp() <= 0;
    }

    public abstract String availableActions();

    public abstract void action(int action);

    public abstract String train();

    public abstract String meditate();

    public abstract String fight();

    public abstract Level getLevel();
}
