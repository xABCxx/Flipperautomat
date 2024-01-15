public class Hole implements FlipperElement {
    private Command command;

    public Hole(Command command) {
        this.command = command;
    }

    @Override
    public void hit() {
        command.execute();
    }
}