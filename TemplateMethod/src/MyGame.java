import entities.Player;
import entities.Question;
import entities.Questions;

import java.util.ArrayList;
import java.util.Scanner;

public class MyGame extends Game{

    private Questions questions = new Questions();
    private ArrayList<Player> players = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void initializeGame(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player());
        }
    }

    @Override
    public boolean endOfGame() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getScore() >= 500) return true;
        }
        return false;
    }

    @Override
    public void playSingleTurn(int player) {
        Player playerInTurn = players.get(player);
        System.out.println(playerInTurn.getName() + "'s turn.");
        Question question = questions.getQuestion();
        System.out.println(question.getQuestion());
        System.out.println(question.getAnswerOptions());
        System.out.println("Answer: ");
        char answer = scanner.nextLine().trim().charAt(0);
        if (answer == question.getAnswer()) {
            System.out.println("Correct!");
            playerInTurn.giveScore(100);
        } else {
            System.out.println("Wrong answer");
        }
    }

    @Override
    public void displayWinner() {
        players.sort(new ListPlayersByScore());
        players.forEach(player -> {
            System.out.println(player.getName() + ": " + player.getScore());
        });
    }
}
