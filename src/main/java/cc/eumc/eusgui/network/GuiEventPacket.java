package cc.eumc.eusgui.network;

import cc.eumc.eusgui.EusGUI;
import cc.eumc.eusgui.model.event.GUIEvent;
import com.google.common.io.BaseEncoding;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

import java.nio.charset.StandardCharsets;

public class GuiEventPacket extends GuiPacket {
    public static final Identifier ID = EusGUI.id("event");

    public GuiEventPacket(GUIEvent event) {
        String json = BaseEncoding.base64().encode(EusGUI.GSON.toJson(event).getBytes(StandardCharsets.UTF_8));
        this.writeShort(json.length());
        this.writeBytes(json.getBytes(StandardCharsets.US_ASCII));
    }

    public static void createAndSend(GUIEvent event) {
        GuiEventPacket packet = new GuiEventPacket(event);
        ClientPlayNetworking.send(ID, packet);
    }

    @Override
    public Identifier getIdentifier() {
        return ID;
    }
}
