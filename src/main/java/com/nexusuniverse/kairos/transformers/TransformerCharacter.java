package com.nexusuniverse.kairos.transformers;

import com.nexusuniverse.kairos.lore.LoreLayer;

public record TransformerCharacter(
    String name,
    LoreLayer loreLayer,
    String faction,
    String role,
    String altMode,
    boolean custom
) {}
