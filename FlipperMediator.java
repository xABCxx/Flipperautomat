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
        if (event.equals("targetHit")) {
            checkTargetsAndOperateRamp();
        }
    }

    private void checkTargetsAndOperateRamp() {
        boolean allTargetsHit = targets.stream().allMatch(Target::isHit);
        if (allTargetsHit) {
            ramp.open();
            targets.forEach(Target::reset);
        }
    }
}
