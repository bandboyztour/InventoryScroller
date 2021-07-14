package net.wedlix.inventoryscroller.listener;

import net.wedlix.inventoryscroller.logic.SlotSwitcherLogic;
import net.wedlix.inventoryscroller.slot.Slot;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.function.Function;

public class SlotSwitcherListener implements Listener {
    private final SlotSwitcherLogic slotSwitcherLogic;
    private final Function<PlayerItemHeldEvent, Slot> slotFunction;

    public SlotSwitcherListener(SlotSwitcherLogic slotSwitcherLogic, Function<PlayerItemHeldEvent, Slot> slotFunction) {
        this.slotSwitcherLogic = slotSwitcherLogic;
        this.slotFunction = slotFunction;
    }

    @EventHandler
    public void onSwitch(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        Slot slot = slotFunction.apply(event);
//        BaseSlotImpl slot = new BaseSlotImpl(
//                event.getNewSlot(),
//                event.getPreviousSlot()
//        );

        boolean cancelSwitch = this.slotSwitcherLogic.switchSlot(player, slot);

        event.setCancelled(cancelSwitch);
    }
}
// Слушатель должен лишь выполнять роль слушателя, логика реализовывается в других модулях