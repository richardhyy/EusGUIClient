package cc.eumc.eusgui.network;

import cc.eumc.eusgui.EusGUI;
import com.google.common.io.BaseEncoding;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

import java.nio.charset.StandardCharsets;

public class GuiCreatePacket extends GuiPacket {
    public static final Identifier ID = EusGUI.id("gui.create");

    public GuiCreatePacket(short length, String json) {
        this.writeShort(length);
        this.writeString(json);
    }

    public static void processGUICreation(MinecraftClient client, ClientPlayNetworkHandler clientPlayNetworkHandler, PacketByteBuf packetByteBuf, PacketSender packetSender) {
        NetworkGUIPacket gui = NetworkGUIPacket.of(packetByteBuf);
        client.execute(() -> {
            EusGUI.NETWORK_GUI_HANDLER.onGuiCreate(gui);
        });
    }

    @Override
    public Identifier getIdentifier() {
        return ID;
    }
}
