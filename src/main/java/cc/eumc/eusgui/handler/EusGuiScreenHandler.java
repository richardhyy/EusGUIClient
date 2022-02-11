package cc.eumc.eusgui.handler;

import cc.eumc.eusgui.EusGUI;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import org.jetbrains.annotations.Nullable;

public class EusGuiScreenHandler extends ScreenHandler {
    public EusGuiScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(9));
    }

    public EusGuiScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(EusGUI.EUS_GUI_HANDLER, syncId);

    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
