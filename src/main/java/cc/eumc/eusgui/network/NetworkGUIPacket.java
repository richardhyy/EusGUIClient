package cc.eumc.eusgui.network;

import cc.eumc.eusgui.model.NetworkGUI;
import com.google.common.io.BaseEncoding;
import net.minecraft.network.PacketByteBuf;

import java.nio.charset.StandardCharsets;

public class NetworkGUIPacket {
    private final String json;

    public NetworkGUIPacket(String json) {
        this.json = json;
    }

    public static NetworkGUIPacket of(PacketByteBuf buffer) {
        short jsonLength = buffer.readShort();
        String json = new String(BaseEncoding.base64().decode(buffer.readCharSequence(jsonLength, StandardCharsets.US_ASCII)), StandardCharsets.UTF_8);
        return new NetworkGUIPacket(json);
    }

    public NetworkGUI toGUI() {
        return NetworkGUI.fromJson(json);
    }

    @Override
    public String toString() {
        return "NetworkGUIPacket{" +
                "json='" + json + '\'' +
                '}';
    }
}
