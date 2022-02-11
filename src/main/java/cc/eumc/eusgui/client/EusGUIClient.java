package cc.eumc.eusgui.client;

import cc.eumc.eusgui.EusGUI;
import cc.eumc.eusgui.screen.EusGuiScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class EusGUIClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
//        ScreenRegistry.register(EusGUI.EUS_GUI_HANDLER, EusGuiScreen::new);
    }
}
