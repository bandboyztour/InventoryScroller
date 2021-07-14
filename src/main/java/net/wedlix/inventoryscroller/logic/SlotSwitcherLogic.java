package net.wedlix.inventoryscroller.logic;

import net.wedlix.inventoryscroller.slot.Slot;
import org.bukkit.entity.Player;

public interface SlotSwitcherLogic {
    boolean switchSlot(Player player, Slot slot);
}
