public class Target implements FlipperElement {
    private Mediator mediator;
    private boolean isHit = false;

    public Target(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void hit() {
        isHit = true;
        mediator.notify(this, "targetHit");
    }

    public boolean isHit() {
        return isHit;
    }

    public void reset() {
        isHit = false;
    }
}