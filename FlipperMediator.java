import java.util.List;

public class FlipperMediator implements Mediator {
    private List<Target> targets;
    private Ramp ramp;

    public FlipperMediator(List<Target> targets, Ramp ramp) {
        this.targets = targets;
        this.ramp = ramp;
    }

    @Override
    public void notify(FlipperElement element, String event) {
        //Todo
    }

    @Override
    public void activateRamp() {
        if (ramp != null) {
            ramp.setActive(true); // Assuming Ramp has a setActive method
            // Perform any additional actions needed when the ramp is activated
            // For example, you might want to increase points or change how the ball behaves
        }
    }

}
