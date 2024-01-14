public class FlipperBat implements FlipperElement {
    //Deutsch: Flipperhebel

    private Command command;

    public FlipperBat(Command command) {
        this.command = command;
    }

    @Override
    public void hit() {
        command.execute();
    }
}

