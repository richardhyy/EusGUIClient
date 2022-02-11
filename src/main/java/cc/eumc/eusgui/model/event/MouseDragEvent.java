package cc.eumc.eusgui.model.event;

public class MouseDragEvent extends GUIEvent {
    private final double mouseRelativeX, mouseRelativeY;
    private final int button;
    private final double deltaX, deltaY;

    public MouseDragEvent(String sourceComponentName, double mouseRelativeX, double mouseRelativeY, int button, double deltaX, double deltaY) {
        super(GUIEventType.MOUSE_DRAG, sourceComponentName);

        this.mouseRelativeX = mouseRelativeX;
        this.mouseRelativeY = mouseRelativeY;
        this.button = button;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public double getMouseRelativeX() {
        return mouseRelativeX;
    }

    public double getMouseRelativeY() {
        return mouseRelativeY;
    }

    public int getButton() {
        return button;
    }

    public double getDeltaX() {
        return deltaX;
    }

    public double getDeltaY() {
        return deltaY;
    }

    @Override
    public String toString() {
        return "MouseDragEvent{" +
                "mouseRelativeX=" + mouseRelativeX +
                ", mouseRelativeY=" + mouseRelativeY +
                ", button=" + button +
                ", deltaX=" + deltaX +
                ", deltaY=" + deltaY +
                '}';
    }
}
