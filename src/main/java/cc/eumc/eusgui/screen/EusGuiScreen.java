package cc.eumc.eusgui.screen;

import cc.eumc.eusgui.handler.EusGuiScreenHandler;
import cc.eumc.eusgui.model.NetworkGUI;
import cc.eumc.eusgui.model.component.GUIComponent;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class EusGuiScreen extends HandledScreen<EusGuiScreenHandler> {
//    private static final Identifier TEXTURE = new Identifier("minecraft", "textures/gui/container/dispenser.png");
    private static final PlayerInventory INVENTORY = new PlayerInventory(null);
    private final NetworkGUI gui;

    public EusGuiScreen(EusGuiScreenHandler handler, NetworkGUI gui) {
        super(handler, INVENTORY, Text.of(gui.getTitle()));
        this.gui = gui;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
//        RenderSystem.setShader(GameRenderer::getPositionTexShader);
//        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
//        RenderSystem.setShaderTexture(0, TEXTURE);
//        int x = (width - backgroundWidth) / 2;
//        int y = (height - backgroundHeight) / 2;
//        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    @Override
    protected void init() {
        super.init();

        gui.initAll();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }

    @Override
    public void onClose() {
        super.onClose();

    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
//        super.render(matrices, mouseX, mouseY, delta);
//        drawMouseoverTooltip(matrices, mouseX, mouseY);

        // draw GUI background
//        Screen.fill(matrices, gui.getX(), gui.getY(), gui.getX() + gui.getWidth(), gui.getY() + gui.getHeight(), 0xEEEEEEEE);

        // draw components
        for (GUIComponent component : gui.getComponents()) {
            int[] relativeCoordinates = getMouseRelativeCoordinates(component, mouseX, mouseY);
            component.render(matrices, relativeCoordinates[0], relativeCoordinates[1], delta);
        }
    }

    private int[] getMouseRelativeCoordinates(GUIComponent component, int mouseX, int mouseY) {
        int[] result = new int[2];
        result[0] = (int) ((mouseX < component.getLeft() || mouseX > component.getLeft() + component.getWidth()) ? -1 : mouseX - component.getLeft());
        result[1] = (int) ((mouseY < component.getTop() || mouseY > component.getTop() + component.getHeight()) ? -1 : mouseY - component.getTop());
        return result;
    }

    private @Nullable GUIComponent getComponentUnderMouse(int mouseX, int mouseY) {
        GUIComponent[] components = gui.getComponents();
        for (int i = components.length - 1; i >= 0; i--) {
            GUIComponent component = components[i];
            if (mouseX >= component.getLeft() && mouseX <= component.getLeft() + component.getWidth() && mouseY >= component.getTop() && mouseY <= component.getTop() + component.getHeight()) {
                return component;
            }
        }
        return null;
    }

    // MARK: - Events

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        System.out.println("click: " + mouseX + ", " + mouseY + ", " + button);
        GUIComponent component = getComponentUnderMouse((int) mouseX, (int) mouseY);
        System.out.println("component: " + component);
        if (component != null) {
            return component.mouseClicked(mouseX, mouseY, button);
        }
        return true;
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        GUIComponent component = getComponentUnderMouse((int) mouseX, (int) mouseY);
        if (component != null) {
            return component.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
        }
        return true;
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        GUIComponent component = getComponentUnderMouse((int) mouseX, (int) mouseY);
        if (component != null) {
            return component.mouseReleased(mouseX, mouseY, button);
        }
        return true;
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        GUIComponent component = gui.getFocusedComponent();
        if (component != null) {
            return component.keyPressed(keyCode, scanCode, modifiers);
        }
        return true;
    }

    public NetworkGUI getGUI() {
        return gui;
    }
}
