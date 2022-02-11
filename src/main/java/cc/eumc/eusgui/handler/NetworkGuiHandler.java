package cc.eumc.eusgui.handler;

import cc.eumc.eusgui.EusGUI;
import cc.eumc.eusgui.network.NetworkGUIPacket;
import cc.eumc.eusgui.screen.EusGuiScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerInventory;

public class NetworkGuiHandler {
    public void onGuiCreate(NetworkGUIPacket guiPacket) {
        System.out.println("NetworkGuiHandler.onGuiCreate: " + guiPacket);
        PlayerInventory inventory = new PlayerInventory(null);
        MinecraftClient.getInstance().setScreenAndRender(
                new EusGuiScreen(EusGUI.EUS_GUI_HANDLER.create(1, inventory), guiPacket.toGUI())
        );
    }
}
