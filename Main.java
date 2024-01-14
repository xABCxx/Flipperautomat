import java.sql.SQLOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Flipper flipper = new Flipper();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please choose an action: ");
            System.out.println("1: Insert Coin");
            System.out.println("2: Press Start");
            System.out.println("3: Cashback");
            System.out.println("0: Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount (0-3) to deposit: ");
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
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

            System.out.println("Current State: " + flipper.getState().getClass().getSimpleName());
            System.out.println("Current Balance: " + flipper.getState().getBalance());
            System.out.println();
        }
    }
}
