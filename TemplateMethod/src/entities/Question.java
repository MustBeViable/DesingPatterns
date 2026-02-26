package entities;

public class Question {
    private final String question;
    private final String answerOptions;
    private final char answer;

    public Question(String question, String answerOptions, char answer) {
        this.question = question;
        this.answerOptions = answerOptions;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswerOptions() {
        return answerOptions;
    }

    public char getAnswer() {
        return answer;
    }
}
