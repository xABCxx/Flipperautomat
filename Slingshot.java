public class Slingshot implements FlipperElement {
    private Command command;

    public Slingshot(Command command) {
        this.command = command;
    }

    @Override
    public void hit() {
        command.execute();
    }
}