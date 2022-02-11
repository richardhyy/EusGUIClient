package cc.eumc.eusgui.network;

import io.netty.buffer.Unpooled;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public abstract class GuiPacket extends PacketByteBuf {
    public GuiPacket() {
        super(Unpooled.buffer());
    }

    public abstract Identifier getIdentifier();
}
