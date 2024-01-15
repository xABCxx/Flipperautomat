import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Flipper {
    private AccountState state;
    private FlipperMediator mediator;

    public Flipper() {
        setState(new NoCreditState(this));
        System.out.println("Aktuelles Guthaben: 0.");

        setupGameElements();
    }

    private void setupGameElements() {


        List<Target> targets = new ArrayList<>(); // List of targets
        Ramp ramp = new Ramp(); // Example of a ramp
        mediator = new FlipperMediator(targets, ramp); // Initialize mediator

        // Set mediator in elements that require it
        // Example: targets.forEach(target -> target.setMediator(mediator));
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public AccountState getState() {
        return this.state;
    }

    public void deposit(int amount) {
        this.state.deposit(amount);
    }

    public void cashback() {
        this.state.cashback();
    }

    public void pressStart() {
        if (this.state.getClass().getSimpleName().equals("NoCreditState")) {
            System.out.println("Kein Spielgeld vorhanden.");
        } else if (this.state.getClass().getSimpleName().equals("PlayingState")) {
            startGame();
        } else {
            setState(new PlayingState(this, state.getBalance()));
            System.out.printf("Aktuelles Guthaben: %d.%n", this.state.getBalance());
        }
    }

    public void startGame() {
        int totalScore = 0;
        int balls = 3;

        while (balls > 0) {
            int score = 0;
            Random random = new Random();
            int x = random.nextInt(10); // Slingshot hits
            int y = random.nextInt(10); // Bumper hits
            int z = random.nextInt(10); // Target hits
            System.out.println("Anzahl der getroffenen Slingshots: " + x);
            System.out.println("Anzahl der getroffenen Bumper: " + y);
            System.out.println("Anzahl der getroffenen Zielpunkte: " + z);

            score += x + y * 2 + z * 25; // Calculate score

            // Ramp activation
            if (x >= 9 && y >= 9) {
                mediator.activateRamp(); // Activate ramp through mediator
                score *= 2; // Double the score
                System.out.println("Die Rampe wurde aktiviert, deine Punkte verdoppeln sich!");
            }

            // Check for Flipperbat hit or ball in hole
            if (x > 6 || y > 6 || z > 6) {
                System.out.println("Der Flipperhebel wurde getroffen, der Ball fliegt wieder hoch!");
                continue; // Skip the rest of the loop iteration
            }

            System.out.println("Der Ball verschwindet in einem Loch. Runde beendet.");
            balls--;
            totalScore += score;
            System.out.println("Diese Runde erreichte Punkte: " + score);
        }
        System.out.println("Game Over. Insgesamt erreichte Punkte: " + totalScore);
    }
}
