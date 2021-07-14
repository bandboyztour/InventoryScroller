package net.wedlix.inventoryscroller.logic.proxy;

import net.wedlix.inventoryscroller.logic.SlotSwitcherLogic;
import net.wedlix.inventoryscroller.slot.Slot;
import org.bukkit.entity.Player;

public class ShiftSlotSwitcherLogicProxy implements SlotSwitcherLogic {
    private final SlotSwitcherLogic logic;

    public ShiftSlotSwitcherLogicProxy(SlotSwitcherLogic logic) {
        this.logic = logic;
    }

    @Override
    public boolean switchSlot(Player player, Slot slot) {
        if (player.isSneaking())
            return logic.switchSlot(player, slot);
        return false;
    }
}
