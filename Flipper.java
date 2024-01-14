import java.util.ArrayList;
import java.util.List;

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

    private void startGame() {
        // Start the actual gameplay
        // This could involve setting up a game loop, handling user inputs, etc.
        // Notify mediator about game start if necessary
    }

    // Additional methods for game logic
}
