public class ReadyState implements AccountState {
    final private Flipper context;
    private int balance;

    ReadyState(Flipper context, int balance) {
        this.context = context;
        this.balance = balance;
    }
    @Override
    public void deposit(int amount) {
        this.balance += amount;
        System.out.printf("Aktuelles Guthaben: %d.%n", this.balance);
    }

    @Override
    public void cashback() {
        this.balance = 0;
        System.out.printf("Aktuelles Guthaben: %d.%n", this.balance);
        checkState();
    }

    public int getBalance() {
        return this.balance;
    }

    private void checkState() {
        if (this.balance < 1) {
            this.context.setState(new NoCreditState(this.context));
        }
    }
}
