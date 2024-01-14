public class Target implements FlipperElement {
    private Command command;

    public Target(Command command) {
        this.command = command;
    }

    @Override
    public void hit() {
        command.execute();
    }
}
