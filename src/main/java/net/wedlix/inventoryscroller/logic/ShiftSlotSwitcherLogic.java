package net.wedlix.inventoryscroller.logic;

import net.wedlix.inventoryscroller.repository.Repository;
import net.wedlix.inventoryscroller.slot.Slot;
import org.bukkit.entity.Player;

public class ShiftSlotSwitcherLogic extends BaseSlotSwitcherLogicImpl {
    public ShiftSlotSwitcherLogic(Repository repository) {
        super(repository);
    }

    @Override
    public boolean switchSlot(Player player, Slot slot) {
        if (player.isSneaking())
            return super.switchSlot(player, slot);
        return false;
    }
}
