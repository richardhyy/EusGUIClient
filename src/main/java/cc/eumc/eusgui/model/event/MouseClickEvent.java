package cc.eumc.eusgui.model.event;

public class MouseClickEvent extends GUIEvent {
    private final double mouseRelativeX;
    private final double mouseRelativeY;
    private final int button;

    public MouseClickEvent(String sourceComponentName, double mouseRelativeX, double mouseRelativeY, int button) {
        super(GUIEventType.MOUSE_CLICKED, sourceComponentName);

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
        return "MouseClickEvent{" +
                "mouseRelativeX=" + mouseRelativeX +
                ", mouseRelativeY=" + mouseRelativeY +
                ", button=" + button +
                '}';
    }
}
