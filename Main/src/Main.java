import BasisKlassen.Quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Quiz q = new Quiz(new ArrayList<>());
        q.menue(new Scanner(System.in));

        /*

        Aus Leons repo zu einem Store:

        Scanner scanner = new Scanner(System.in);
        int selection = 0;
        // TODO: implement the menu
        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. List all articles");
            System.out.println("2. Add article to cart");
            System.out.println("3. View cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    store.printAllArticles();
                    break;
                case 2:
                    // TODO:
                    System.out.println("Enter article id:");
                    int id = scanner.nextInt();

                    cart.addToCart(id, store);
                    break;
                case 3:
                    cart.printCart();
                    break;
                case 4:
                    System.out.println("your price: " + cart.checkout());
                    break;
                case 5:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Wrong input...");
                    break;
            }
        } while (selection != 5);
         */


    }
}