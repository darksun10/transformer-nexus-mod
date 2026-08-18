package com.nexusuniverse.kairos.lore;

import java.util.LinkedHashMap;
import java.util.Map;

public final class LoreRegistry {
    private final Map<String, LoreLayer> entries = new LinkedHashMap<>();

    public void register(String id, LoreLayer layer) {
        entries.put(id.toLowerCase(), layer);
    }

    public LoreLayer getLayer(String id) {
        return entries.get(id.toLowerCase());
    }

    public Map<String, LoreLayer> entries() {
        return Map.copyOf(entries);
    }
}
