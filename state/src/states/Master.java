package states;

import entities.Player;

public class Master extends GameState{
    public Master(Player player) {
        super(player);
    }

    @Override
    public String availableActions() {
        return "";
    }

    @Override
    public void action(int action) {

    }

    @Override
    public String train() {
        player.setExp(player.getExp()+10);
        return player.getName() + ": Training. Exp now: " + player.getExp();
    }

    @Override
    public String meditate() {
        if (player.getHp() < 90) {
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
            player.setHp(player.getHp()-10);
            player.setExp(player.getExp()+50);
            return player.getName() + " fought. Player hp: " + player.getHp() + " exp: " + player.getExp();
        }
    }

    @Override
    public Level getLevel() {
        return Level.master;
    }


}
