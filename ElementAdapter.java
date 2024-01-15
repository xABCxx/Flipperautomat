public class ElementAdapter implements FlipperElement {
    private IncompatibleFlipperElement incompElement;

    public ElementAdapter(IncompatibleFlipperElement incompElement) {
        this.incompElement = incompElement;
    }

    @Override
    public void hit() {

        incompElement.activate();
    }
}
