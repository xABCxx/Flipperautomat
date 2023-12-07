public class PlayingState implements AccountState {
    final private Flipper context;
    private int balance;

    public PlayingState(Flipper context, int balance) {
        this.context = context;
        this.balance = balance;
        this.balance -= 1;
    }

    public void deposit(int amount) {
        this.balance += amount;
        System.out.printf("Aktuelles Guthaben: %d.%n", this.balance);
    }

    public void cashback() {
        this.balance = 0;
        System.out.printf("Aktuelles Guthaben: %d.%n", this.balance);
    }

    public int getBalance() {
        return this.balance;
    }
}
