package BasisKlassen;

import java.util.ArrayList;

public class Questions {

    private String text;
    private ArrayList<String> choices;
    private int correctAnswer;

    public Questions(String text, int correctAnswer, ArrayList<String> choices) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.choices = choices;
    }

    public String getText() {
        return text;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctAnswer;
    }
}
