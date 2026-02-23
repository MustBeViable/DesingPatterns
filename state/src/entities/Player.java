package entities;

import states.*;

import java.util.Scanner;

public class Player {
    private final Scanner scanner;
    private final String name;
    private GameState level;
    private int exp;
    private int hp;

    public Player(String name, Scanner scanner) {
        this.scanner = scanner;
        this.name = name;
        this.exp = 0;
        this.hp = 100;
        this.level = new Novice(this);
    }

    public void play() {
        while (level.getLevel() != Level.master) {
            if (this.getHp() <= 0) {
                break;
            }
            System.out.println("Next day.");
            System.out.println("player stats:");
            System.out.println("Name: " + this.getName());
            System.out.println("Level: " + level.getLevel());
            System.out.println("Hp: " + this.getHp());
            System.out.println("Exp: " + this.getExp());
            System.out.println(level.availableActions());
            int action = scanner.nextInt();
            switch (action) {
                case (1) -> System.out.println(level.train());
                case (2) -> System.out.println(level.meditate());
                case (3) -> System.out.println(level.fight());
                default -> System.out.println("You need to choose a action");
            }
            if (this.getExp() >= 200) {
                this.setLevel(new Master(this));
            } else if (this.getExp() >= 100) {
                this.setLevel(new Expert(this));
            } else if (this.getExp() >= 50) {
                this.setLevel(new Intermediate(this));
            }
        }
        if (this.getHp() > 0) {
            System.out.println("You won!");
        }
    }

    public GameState getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public int getExp() {
        return exp;
    }

    public int getHp() {
        return hp;
    }

    public void setLevel(GameState level) {
        this.level = level;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
