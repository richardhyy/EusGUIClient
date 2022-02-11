package cc.eumc.eusgui.model.component;

import cc.eumc.eusgui.model.NetworkGUI;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class MinecraftButton extends NetworkGUIComponent {
    private String text;
    private transient ButtonWidget buttonWidget;

    public MinecraftButton(String name, int top, int left, int width, int height, String text) {
        super(name, ComponentType.MINECRAFT_BUTTON, top, left, width, height);
        this.text = text;
    }

    @Override
    public void init(NetworkGUI gui) {
        super.init(gui);
        buttonWidget = new ButtonWidget(left, top, width, height, Text.of(text), new ButtonWidget.PressAction() {
            @Override
            public void onPress(ButtonWidget button) {
                System.out.println("Pressed: " + name);
            }
        });
    }

    @Override
    public void render(MatrixStack matrices, int mouseRelativeX, int mouseRelativeY, float delta) {
        buttonWidget.render(matrices, left, top, delta);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        buttonWidget.setWidth(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
