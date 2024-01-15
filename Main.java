import java.sql.SQLOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Flipper flipper = new Flipper();
        Scanner scanner = new Scanner(System.in);

        /*
        public class Main {
    public static void main(String[] args) {
        Flipper flipper = new Flipper();

        // check of initial state (must be NoCreditState)
        // check of initial credit (must be 0)
        System.out.println(flipper.getState());
        System.out.println(flipper.getState().getClass().getSimpleName());

        System.out.println("\n");

        // try to press the start button without credit
        flipper.pressStart();
        System.out.println(flipper.getState());

        System.out.println("\n");

        // increase credit by 2
        // check of state (must switch to ReadyState)
        flipper.deposit(2);
        System.out.println(flipper.getState());

        System.out.println("\n");

        // press start button
        // change to PlayingState
        flipper.pressStart();
        System.out.println(flipper.getState());

        System.out.println("\n");

        // press start button
        // print names of programmers
        flipper.pressStart();

        System.out.println("\n");
    }
}
         */

        while (true) {
            System.out.println("Bitte wählen Sie eine Aktion aus: ");
            System.out.println("1: Münzen einwerfen");
            System.out.println("2: Start");
            System.out.println("3: Geld zurück");
            System.out.println("0: Spiel beenden");
            System.out.print("Auswahl: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Betrag (0-3) einwerfen: ");
                    int amount = scanner.nextInt();
                    flipper.deposit(amount);
                    break;
                case 2:
                    flipper.pressStart();
                    break;
                case 3:
                    flipper.cashback();
                    break;
                case 0:
                    System.out.println("Spiel wird beendet...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Ungültige Auswahl.");
                    break;
            }

            System.out.println("Current State: " + flipper.getState().getClass().getSimpleName());
            System.out.println("Current Balance: " + flipper.getState().getBalance());
            System.out.println();
        }
    }
}
