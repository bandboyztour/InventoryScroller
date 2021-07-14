package net.wedlix.inventoryscroller.slot;

public class BaseSlotImpl implements Slot {
    private final int nextSlot;
    private final int previousSlot;
    private final Direction direction;

    public BaseSlotImpl(int nextSlot, int previousSlot) {
        this.nextSlot = nextSlot;
        this.previousSlot = previousSlot;
        if (nextSlot >= 6) {
            direction = Direction.West;
        } else if (nextSlot <= 2) {
            direction = Direction.East;
        } else {
            direction = Direction.SaveCurrent;
        }
    }

    public int getNextSlot() {
        return nextSlot;
    }

    public int getPreviousSlot() {
        return previousSlot;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "nextSlot=" + nextSlot +
                ", previousSlot=" + previousSlot +
                ", direction=" + direction +
                '}';
    }
}
