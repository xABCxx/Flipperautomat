public class NoCreditState implements AccountState {
    final private Flipper context;
    private int balance;

    public NoCreditState(Flipper context) {
        this.balance = 0;
        this.context = context;
    }

    @Override
    public void deposit(int amount) {
        this.balance += amount;
        System.out.printf("Aktuelles Guthaben: %d.%n", this.balance);
        checkState();
    }

    public void cashback() {
        this.balance = 0;
        System.out.printf("Aktuelles Guthaben: 0.%n");
    }

    public int getBalance() {
        return this.balance;
    }

    private void checkState() {
        if (this.balance >= 1) {
            context.setState(new ReadyState(this.context, this.balance));
        }
    }
}
