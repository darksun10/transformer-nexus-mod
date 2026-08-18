package com.nexusuniverse.plugin.transformer;
import com.nexusuniverse.plugin.lore.LoreLayer;
public record TransformerCharacter(String name,LoreLayer loreLayer,String species,String faction,String rank,String altMode,TransformationState state,int maxEnergon) {}
