package net.wedlix.inventoryscroller.logic;

import net.wedlix.inventoryscroller.slot.Direction;
import net.wedlix.inventoryscroller.repository.Repository;
import net.wedlix.inventoryscroller.slot.Slot;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.UUID;

public class BaseSlotSwitcherLogicImpl implements SlotSwitcherLogic {
    private final Repository repository;

    public BaseSlotSwitcherLogicImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public boolean switchSlot(Player player, Slot slot) {
        UUID uuid = player.getUniqueId();
        int switchIndex = repository.getOrInsert(uuid, 0);
        Direction direction = slot.getDirection();

        PlayerInventory inventory = player.getInventory();
        boolean cancelSwitch = false;

        if (direction == Direction.East) {
            if (switchIndex > 0) {
                switchIndex--;
                cancelSwitch = true;
            }
        } else if (direction == Direction.West) {
            if (switchIndex < 27) {
                switchIndex++;
                cancelSwitch = true;
            }
        }

        if (cancelSwitch) {
            swapItems(inventory, switchIndex, direction);
            repository.updateValue(uuid, switchIndex);
        }
        return cancelSwitch;
    }

    public void swapItems(Inventory inventory, int switchIndex, Direction direction) {
        ItemStack[] items = inventory.getStorageContents();
        int replacementIndex = direction == Direction.West ? switchIndex + 8 : switchIndex + 9;

        if (direction == Direction.West) {
            for (int i = 0; i < 8; i++)
                swap(items, i, i + 1);
        } else {
            for (int i = 8; i > 0; i--)
                swap(items, i, i - 1);
        }

        int changePosition = getDirectionAsPosition(direction);
        swap(items, changePosition, replacementIndex);

        inventory.setStorageContents(items);
    }

    private int getDirectionAsPosition(Direction direction) {
        return direction == Direction.East ? 0 : 8;
    }

    private void swap(ItemStack[] source, int changePosition, int replacementIndex) {
        ItemStack temp = source[changePosition];
        source[changePosition] = source[replacementIndex];
        source[replacementIndex] = temp;
    }
}
