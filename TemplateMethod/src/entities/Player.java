package entities;

public class Player {
    protected static int index = 1;
    private final String name;
    private int score;

    public Player() {
        this.name = "player " + index + ".";
        this.score = 0;
        index++;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void giveScore(int score) {
        this.score = this.score + score;
    }
}
