package cc.eumc.eusgui.model.component;

import cc.eumc.eusgui.model.NetworkGUI;
import cc.eumc.eusgui.model.event.KeyPressEvent;
import cc.eumc.eusgui.model.event.MouseClickEvent;
import cc.eumc.eusgui.model.event.MouseDragEvent;
import cc.eumc.eusgui.model.event.MouseReleaseEvent;
import cc.eumc.eusgui.network.GuiEventPacket;
import net.minecraft.client.util.math.MatrixStack;

public class NetworkGUIComponent extends GUIComponent {
    public NetworkGUIComponent(String name, ComponentType type, int top, int left, int width, int height) {
        super(name, type, top, left, width, height);
    }

    @Override
    public void render(MatrixStack matrices, int mouseRelativeX, int mouseRelativeY, float delta) {

    }

    @Override
    public void init(NetworkGUI gui) {

    }

    @Override
    public boolean mouseClicked(double mouseRelativeX, double mouseRelativeY, int button) {
        GuiEventPacket.createAndSend(new MouseClickEvent(name, mouseRelativeX, mouseRelativeY, button));
        return true;
    }

    @Override
    public boolean mouseDragged(double mouseRelativeX, double mouseRelativeY, int button, double deltaX, double deltaY) {
        GuiEventPacket.createAndSend(new MouseDragEvent(name, mouseRelativeX, mouseRelativeY, button, deltaX, deltaY));
        return true;
    }

    @Override
    public boolean mouseReleased(double mouseRelativeX, double mouseRelativeY, int button) {
        GuiEventPacket.createAndSend(new MouseReleaseEvent(name, mouseRelativeX, mouseRelativeY, button));
        return true;
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        GuiEventPacket.createAndSend(new KeyPressEvent(name, keyCode, scanCode, modifiers));
        return true;
    }
}
