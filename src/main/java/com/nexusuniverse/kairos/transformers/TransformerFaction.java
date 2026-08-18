package com.nexusuniverse.kairos.transformers;

import com.nexusuniverse.kairos.lore.LoreLayer;

public record TransformerFaction(
    String id,
    String displayName,
    LoreLayer loreLayer,
    boolean custom
) {}
