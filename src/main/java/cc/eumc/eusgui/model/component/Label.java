package cc.eumc.eusgui.model.component;

import cc.eumc.eusgui.model.NetworkGUI;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class Label extends NetworkGUIComponent {
    private String text;
    private int color;

    public Label(String name, int top, int left, int width, int height, String text, int color) {
        super(name, ComponentType.LABEL, top, left, width, height);
        this.text = text;
        this.color = color;
    }

    @Override
    public void init(NetworkGUI gui) {
        super.init(gui);
        setWidth(MinecraftClient.getInstance().textRenderer.getWidth(text));
        setHeight(MinecraftClient.getInstance().textRenderer.fontHeight);
    }

    @Override
    public void render(MatrixStack matrices, int mouseRelativeX, int mouseRelativeY, float delta) {
        MinecraftClient client = MinecraftClient.getInstance();
        client.textRenderer.draw(matrices, text, left, top, color);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
