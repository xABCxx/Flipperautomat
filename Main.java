import java.sql.SQLOutput;

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
