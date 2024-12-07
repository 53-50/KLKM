package BasisKlassen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private ArrayList<Questions> questions;
    private Player p1;
    private Scanner scanner = new Scanner(System.in);

    public Quiz(ArrayList<Questions> questions) {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Questions q) {
        this.questions.add(q);
    }

    public void menue (Scanner scan) {

        String[] menue = new String[] {"1. Frage hinzufügen", "2. Spiel starten", "3. Spiel starten (Testfragen)", "4. Beenden"};
        int inpMenue = 0;
        int corAnswer;
        String inpQuestion;
        String inpAnswer;
        String plaName;

        System.out.println();
        System.out.println("First things, first...");
        System.out.println();
        System.out.print("Gib deinen Spielernamen ein amk: ");
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

            while (inpMenue != 1 && inpMenue != 2 && inpMenue != 3 && inpMenue != 4) {
                System.out.println("Bruda/Schwesta... kannst du nicht lesen was im Menü steht ?");
                System.out.print("> ");
                inpMenue = scanner.nextInt();
            }
            scanner.nextLine();

            if (inpMenue == 1) {
                ArrayList<String> choices = new ArrayList<>();

                System.out.print(p1.getName() + ", gib die Frage ein Olum: ");
                inpQuestion = scanner.nextLine();

                for (int j = 1; j < 5; j++) {
                    System.out.print("Ajd gib die " + j + ". Antwortmöglichkeit ein: ");
                    inpAnswer = scanner.nextLine();
                    choices.add(inpAnswer);
                }

                System.out.println();
                System.out.print("Welche von den Antworten ist richtig abi ? (Nummer): ");
                corAnswer = scanner.nextInt();
                scanner.nextLine();
                System.out.println();

                Questions frage = new Questions(inpQuestion, corAnswer, choices);
                addQuestion(frage);
            } else if (inpMenue == 2) {
                start(new Scanner(System.in));
            } else if (inpMenue == 3) {
                Questions Frage1 = new Questions("Das ist ein Test1", 1, new ArrayList<>(List.of(new String[]{"Test1", "Test2", "Test3", "Test4"})));
                addQuestion(Frage1);

                Questions Frage2 = new Questions("Das ist ein Test2", 2, new ArrayList<>(List.of(new String[]{"Test1", "Test2", "Test3", "Test4"})));
                addQuestion(Frage2);

                Questions Frage3 = new Questions("Das ist ein Test3", 3, new ArrayList<>(List.of(new String[]{"Test1", "Test2", "Test3", "Test4"})));
                addQuestion(Frage3);

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
            System.out.println("Korrekt ! So wie mein 3er BMW!");
            p1.setScore(p1.getScore() + 1);
        } else {
            System.out.println("Falsch ! Die richtige Antwort wäre " + "'" + q.getChoices().get(q.getCorrectAnswer() - 1) + "'" + " gewesen sik dir lan.");
        }
    }

    public void start(Scanner scan) {
        String cont;
        int count = 0;

        System.out.println("Selam aleykum zum Quiz!");
        System.out.println();
        System.out.print("Drücke >>ENTER<< wenn du ready bist amk ;)");
        cont = scanner.nextLine();
        System.out.println();

        for (Questions q : questions) {
            askQuestion(q, scan);
            count++;
            System.out.println();
            if (count < questions.size()) {
                System.out.print("Drücke >>ENTER<< um zur nächsten Frage zu kommen abi");
                cont = scanner.nextLine();
                System.out.println();
            } else {
                System.out.println("Deine Punkteanzahl abi: " + p1.getScore());
                System.out.println();
                p1.setScore(0);
                System.out.print("Drücke >>ENTER<< um zum Menü zurück zu kehren. Ajd, verpiss dich jetzt...");
                cont = scanner.nextLine();
                System.out.println();
            }
        }
    }
}
