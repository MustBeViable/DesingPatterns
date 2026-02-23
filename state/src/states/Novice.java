package states;

import entities.Player;

public class Novice extends GameState{

    public Novice(Player player) {
        super(player);
    }

    @Override
    public String availableActions() {
        return "What do you want to do? Train (1)";
    }

    @Override
    public String train() {
        player.setExp(player.getExp()+10);
        return player.getName() + ": Training Exp now: " + player.getExp();
    }

    @Override
    public String meditate() {
        return "You cannot meditate yet.";
    }

    @Override
    public String fight() {
        return "You cannot fight yet";
    }

    @Override
    public Level getLevel() {
        return Level.novice;
    }
}
