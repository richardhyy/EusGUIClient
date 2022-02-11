package cc.eumc.eusgui.model.event;

public class MouseReleaseEvent extends GUIEvent {
    private final double mouseRelativeX;
    private final double mouseRelativeY;
    private final int button;

    public MouseReleaseEvent(String sourceComponentName, double mouseRelativeX, double mouseRelativeY, int button) {
        super(GUIEventType.MOUSE_RELEASED, sourceComponentName);

        this.mouseRelativeX = mouseRelativeX;
        this.mouseRelativeY = mouseRelativeY;
        this.button = button;
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

    @Override
    public String toString() {
        return "MouseReleaseEvent{" +
                "mouseRelativeX=" + mouseRelativeX +
                ", mouseRelativeY=" + mouseRelativeY +
                ", button=" + button +
                '}';
    }
}
