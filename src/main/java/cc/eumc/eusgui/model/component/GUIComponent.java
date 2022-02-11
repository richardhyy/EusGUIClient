package cc.eumc.eusgui.model.component;

import cc.eumc.eusgui.model.NetworkGUI;
import net.minecraft.client.util.math.MatrixStack;

public abstract class GUIComponent {
    protected ComponentType type;
    protected String name;
    protected int top;
    protected int left;
    protected int width;
    protected int height;

    public GUIComponent(String name, ComponentType type, int top, int left, int width, int height) {
        this.name = name;
        this.type = type;
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    /**
     * Draw the component.
     * @param matrices the matrix stack
     * @param mouseRelativeX the relative mouse x position inside the component. -1 if not inside.
     * @param mouseRelativeY the relative mouse y position inside the component. -1 if not inside.
     * @param delta the delta time
     */
    public abstract void render(MatrixStack matrices, int mouseRelativeX, int mouseRelativeY, float delta);

    public abstract void init(NetworkGUI gui);

    public abstract boolean mouseClicked(double mouseRelativeX, double mouseRelativeY, int button);

    public abstract boolean mouseDragged(double mouseRelativeX, double mouseRelativeY, int button, double deltaX, double deltaY);

    public abstract boolean mouseReleased(double mouseRelativeX, double mouseRelativeY, int button);

    public abstract boolean keyPressed(int keyCode, int scanCode, int modifiers);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "GUIComponent{" +
                "type=" + type +
                ", name='" + name + '\'' +
                '}';
    }
}
