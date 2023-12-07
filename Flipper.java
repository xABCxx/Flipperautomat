public class Flipper {
    private AccountState state;

    public Flipper() {
        setState(new NoCreditState(this));
        System.out.println("Aktuelles Guthaben: 0.");
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    // for testing purposes only
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
            System.out.printf("Programmierer:%nAnna Balazs-Csiki%nMichael Huebl");
        } else {
            setState(new PlayingState(this, state.getBalance()));
            System.out.printf("Aktuelles Guthaben: %d.%n", this.state.getBalance());
        }
    }
}
