package cc.eumc.eusgui;

import cc.eumc.eusgui.handler.EusGuiScreenHandler;
import cc.eumc.eusgui.handler.NetworkGuiHandler;
import cc.eumc.eusgui.network.GuiCreatePacket;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class EusGUI implements ModInitializer {
    public static final String ID = "eusgui";
    public static final ScreenHandlerType<EusGuiScreenHandler> EUS_GUI_HANDLER = ScreenHandlerRegistry.registerSimple(EusGUI.id("eus_gui_handler"), EusGuiScreenHandler::new);;
    public static final NetworkGuiHandler NETWORK_GUI_HANDLER = new NetworkGuiHandler();
    public static final Gson GSON = new GsonBuilder().create();

    public static Identifier id(String path) {
        return new Identifier(EusGUI.ID, path);
    }

    @Override
    public void onInitialize() {
        ClientPlayNetworking.registerGlobalReceiver(id("create"), GuiCreatePacket::processGUICreation);

        System.out.println("Hello world!");
    }
}
