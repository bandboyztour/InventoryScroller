package net.wedlix.inventoryscroller.repository;

import java.util.HashMap;
import java.util.UUID;

public class RepositoryImpl implements Repository {
    private final HashMap<UUID, Integer> switcherIndexes = new HashMap<>();

    @Override
    public Integer getValue(UUID key) {
        return switcherIndexes.get(key);
    }

    @Override
    public Integer getOrInsert(UUID key, Integer integer) {
        Integer val = switcherIndexes.putIfAbsent(key, integer);
        return val == null ? integer : val;
    }

    @Override
    public void removeValue(UUID key) {
        switcherIndexes.remove(key);
    }

    @Override
    public void updateValue(UUID key, Integer t) {
        switcherIndexes.replace(key, t);
    }
}
