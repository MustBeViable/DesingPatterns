package states;

import entities.Player;

public class Expert extends GameState {
    public Expert(Player player) {
        super(player);
    }

    @Override
    public String availableActions() {
        return "What do you want to do? Train (1), meditate (2), fight (3)";
    }

    @Override
    public void action(int action) {
        switch (action) {
            case (1) -> System.out.println(this.train());
            case (2) -> System.out.println(this.meditate());
            case (3) -> System.out.println(this.fight());
            default -> System.out.println("You need to choose a action");
        }
        if (player.getExp() >= 200) {
            player.setLevel(new Master(player));
        }
    }

    @Override
    public String train() {
        player.setExp(player.getExp()+10);
        return player.getName() + ": Training. Exp now: " + player.getExp();
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
        if (player.getHp() < 10) {
            player.setHp(0);
            return "You died";
        } else {
            player.setHp(Math.max(player.getHp() - 50, 0));
            if (player.getHp() > 0) {
                player.setExp(player.getExp() + 50);
            }
            return player.getName() + " fought. Player hp: " + player.getHp() + " exp: " + player.getExp();
        }
    }

    @Override
    public Level getLevel() {
        return Level.expert;
    }
}
