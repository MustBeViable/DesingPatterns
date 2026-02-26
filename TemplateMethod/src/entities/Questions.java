package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Questions {
    private List<Question> questions = new ArrayList<>();
    private final int length;
    private Random random = new Random();

    public Questions() {
        loadFromFile();
        this.length = questions.size();
    }

    private void loadFromFile() {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("TemplateMethod/src/resources/questions.txt"))) {

            while (true) {
                String q = br.readLine();
                if (q == null) break;
                if (q.trim().isEmpty()) continue;

                String a = br.readLine();
                String b = br.readLine();
                String c = br.readLine();
                String d = br.readLine();
                char correct = br.readLine().trim().charAt(0);

                String options = String.join("\n", a, b, c, d);
                questions.add(new Question(q, options, correct));
            }

        } catch (IOException e) {
            throw new RuntimeException("Kysymysten lukeminen epäonnistui", e);
        }
    }

    public Question getQuestion() {
        return questions.get(random.nextInt(length-1));
    }
}
