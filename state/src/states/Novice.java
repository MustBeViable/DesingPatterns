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
    public void action(int action) {
        switch (action) {
            case (1) -> System.out.println(this.train());
            default -> System.out.println("You need to choose a action");
        }
        if (player.getExp() >= 50) {
            player.setLevel(new Intermediate(player));
        }
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
