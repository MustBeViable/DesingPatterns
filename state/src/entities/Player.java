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
            System.out.println("Next day.");
            System.out.println("player stats:");
            System.out.println("Name: " + this.getName());
            System.out.println("Level: " + level.getLevel());
            System.out.println("Hp: " + this.getHp());
            System.out.println("Exp: " + this.getExp());
            System.out.println(level.availableActions());
            int action = scanner.nextInt();
            level.action(action);
            if (level.checkGame()) break;
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
