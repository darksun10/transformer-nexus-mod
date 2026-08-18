package com.nexusuniverse.kairos;

import org.bukkit.plugin.java.JavaPlugin;
import com.nexusuniverse.kairos.commands.KairosCommand;
import com.nexusuniverse.kairos.commands.VerticonCommand;
import com.nexusuniverse.kairos.data.CharacterStore;

public final class KairosPlugin extends JavaPlugin {
    private CharacterStore characterStore;

    @Override
    public void onEnable() {
        characterStore = new CharacterStore(this);
        characterStore.load();

        getCommand("kairos").setExecutor(new KairosCommand(this));
        getCommand("verticon").setExecutor(new VerticonCommand(this, characterStore));

        getLogger().info("Kairos online. Nexus Universe systems initialized.");
    }

    @Override
    public void onDisable() {
        if (characterStore != null) characterStore.save();
        getLogger().info("Kairos offline. Nexus Universe systems saved.");
    }

    public CharacterStore getCharacterStore() {
        return characterStore;
    }
}
