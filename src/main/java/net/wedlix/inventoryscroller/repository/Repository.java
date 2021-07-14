package net.wedlix.inventoryscroller.repository;

import java.util.UUID;
import java.util.function.UnaryOperator;

public interface Repository {
    Integer getValue(UUID key);
    Integer getOrInsert(UUID key, Integer integer);
    void removeValue(UUID key);
    void updateValue(UUID key, Integer t);
}
