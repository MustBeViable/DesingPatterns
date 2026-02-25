package states;

import entities.Player;

public class Intermediate extends GameState{
    public Intermediate(Player player) {
        super(player);
    }

    @Override
    public String availableActions() {
        return "What do you want to do? Train (1) or meditate to heal (2)";
    }

    @Override
    public void action(int action) {
        switch (action) {
            case (1) -> System.out.println(this.train());
            case (2) -> System.out.println(this.meditate());
            default -> System.out.println("You need to choose a action");
        }
        if (player.getExp() >= 100) {
            player.setLevel(new Expert(player));
        }

    }

    @Override
    public String train() {
        player.setExp(player.getExp()+10);
        return player.getName() + ": Training Exp now: " + player.getExp();
    }

    @Override
    public String meditate() {
        if (player.getHp() <= 90) {
            player.setHp(player.getHp() + 10);
            return player.getName() + ": Meditating Hp is now: " + player.getHp();
        } else if (100 > player.getHp() && player.getHp() > 90) {
            player.setHp(100);
            return player.getName() + ": Meditating. Hp is now: " + player.getHp();
        } else {
            return player.getName() + " cannot meditate. Hp is max: " + player.getHp();
        }
    }

    @Override
    public String fight() {
        return player.getName() + " cannot fight yet";
    }

    @Override
    public Level getLevel() {
        return Level.intermediate;
    }
}
