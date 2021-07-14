package net.wedlix.inventoryscroller.slot;

public interface Slot {
    int getNextSlot();

    int getPreviousSlot();

    Direction getDirection();
}
