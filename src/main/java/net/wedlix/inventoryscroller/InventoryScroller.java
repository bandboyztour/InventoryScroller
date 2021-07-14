package net.wedlix.inventoryscroller;

import net.wedlix.inventoryscroller.listener.SlotSwitcherListener;
import net.wedlix.inventoryscroller.logic.BaseSlotSwitcherLogicImpl;
import net.wedlix.inventoryscroller.logic.ShiftSlotSwitcherLogic;
import net.wedlix.inventoryscroller.logic.SlotSwitcherLogic;
import net.wedlix.inventoryscroller.repository.Repository;
import net.wedlix.inventoryscroller.repository.RepositoryImpl;
import net.wedlix.inventoryscroller.slot.BaseSlotImpl;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.Plugin;

@Plugin(name = "InventorySwitcher", version = "0.0.1")
public class InventoryScroller extends JavaPlugin {
    @Override
    public void onEnable() {
        Repository repository = new RepositoryImpl();

        SlotSwitcherLogic slotSwitcherLogic = new ShiftSlotSwitcherLogic(repository);

        Listener listener = new SlotSwitcherListener(
                slotSwitcherLogic,
                event -> new BaseSlotImpl(
                        event.getNewSlot(),
                        event.getPreviousSlot()
                )
        );

        Bukkit.getPluginManager().registerEvents(listener, this);
    }
}
