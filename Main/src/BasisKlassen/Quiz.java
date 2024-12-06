package BasisKlassen;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    ArrayList<String> choices;
    ArrayList<Questions> questions;
    Player p1 = null;

    public Quiz(ArrayList<Questions> questions) {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Questions q) {
        this.questions.add(q);
    }

    public void menue (Scanner scan) {
        Scanner scanner = new Scanner(System.in);

        String[] menue = new String[] {"1. Frage hinzufügen", "2. Spiel starten", "3. Beenden"};
        int inpMenue;
        String inpQuestion;
        String inpAnswer;
        int corAnswer;
        String plaName;

        System.out.println();
        System.out.println("First things, first...");
        System.out.println();
        System.out.print("Gib deinen Spielernamen ein: ");
        plaName = scanner.nextLine();
        this.p1 = new Player(plaName);
        System.out.println();

        do {
            for (int i = 0; i < menue.length; i++) {
                System.out.println(menue[i]);
            }
            System.out.println();
            System.out.print("> ");
            inpMenue = scanner.nextInt();
            scanner.nextLine();

            if (inpMenue == 1) {
                ArrayList<String> choices = new ArrayList<>();

                System.out.print(p1.getName() + ", gib die Frage ein: ");
                inpQuestion = scanner.nextLine();

                for (int j = 1; j < 5; j++) {
                    System.out.print("Gib die " + j + ". Antwortmöglichkeit ein (Bsp.: " + j + ". Antwort): ");
                    inpAnswer = scanner.nextLine();
                    choices.add(inpAnswer);
                }

                System.out.println();
                System.out.print("Welche von den Antworten ist richtig? (Nummer): ");
                corAnswer = scanner.nextInt();
                scanner.nextLine();
                System.out.println();

                Questions frage = new Questions(inpQuestion, corAnswer, choices);
                addQuestion(frage);
            } else if (inpMenue == 2) {
                start(new Scanner(System.in));
            } else {
                break;
            }
        } while (true);
    }

    public void askQuestion(Questions q, Scanner answer) {
        System.out.println(q.getText());
        for (int i = 0; i < q.getChoices().size(); i++) {
            System.out.println((i + 1) + ". " + q.getChoices().get(i));
        }

        System.out.print("Deine Antwort: ");
        int userAnswer = answer.nextInt();

        if (q.isCorrect(userAnswer)){
            System.out.println("Correct!");
            p1.setScore(p1.getScore() + 1);
        } else {
            System.out.println("Falsch ! Die richtige Antwort wäre " + "'" + q.getCorrectAnswer() + "'" + " gewesen.");
        }
    }

    public void start(Scanner scan) {
        System.out.println("Willkommen zum Quiz!");
        System.out.println();

        for (Questions q : questions) {
            askQuestion(q, scan);
            System.out.println();
        }
        System.out.println("Deine Punkteanzahl: " + p1.getScore());
        System.out.println();
    }
}
