package cc.eumc.eusgui.model.component;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;

public class Button extends NetworkGUIComponent {
    private String text;
    private String actionScript;
    private String tooltip;
    private int frontColor;
    private int backgroundColor;

    public Button(String name, int top, int left, int width, int height, String text, int frontColor, int backgroundColor, String actionScript, String tooltip) {
        super(name, ComponentType.BUTTON, top, left, width, height);
        this.text = text;
        this.frontColor = frontColor;
        this.backgroundColor = backgroundColor;
        this.actionScript = actionScript;
        this.tooltip = tooltip;
    }

    @Override
    public void render(MatrixStack matrices, int mouseRelativeX, int mouseRelativeY, float delta) {
        super.render(matrices, mouseRelativeX, mouseRelativeY, delta);

        Screen.fill(matrices, this.left, this.top, this.left + this.width, this.top + this.height, this.backgroundColor);

        MinecraftClient client = MinecraftClient.getInstance();
        client.textRenderer.draw(matrices, text, left + (float)width/2 - (float)client.textRenderer.getWidth(text) / 2, top + (float)height/2 - (float)client.textRenderer.fontHeight / 2, frontColor);
    }

    @Override
    public boolean mouseClicked(double mouseRelativeX, double mouseRelativeY, int button) {
        System.out.println(actionScript);
        return super.mouseClicked(mouseRelativeX, mouseRelativeY, button);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getActionScript() {
        return actionScript;
    }

    public void setActionScript(String actionScript) {
        this.actionScript = actionScript;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public int getFrontColor() {
        return frontColor;
    }

    public void setFrontColor(int frontColor) {
        this.frontColor = frontColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
