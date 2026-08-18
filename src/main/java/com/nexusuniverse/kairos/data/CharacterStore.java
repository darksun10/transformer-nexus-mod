package com.nexusuniverse.kairos.data;

import com.nexusuniverse.kairos.KairosPlugin;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.*;

public final class CharacterStore {
    private final KairosPlugin plugin;
    private final Map<String, CharacterProfile> characters = new LinkedHashMap<>();
    private File file;

    public CharacterStore(KairosPlugin plugin) { this.plugin = plugin; }

    public void load() {
        if (!plugin.getDataFolder().exists()) plugin.getDataFolder().mkdirs();
        file = new File(plugin.getDataFolder(), "characters.yml");
        if (!file.exists()) return;
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
        for (String key : yml.getKeys(false)) {
            characters.put(key.toLowerCase(), new CharacterProfile(
                yml.getString(key + ".name", key),
                yml.getString(key + ".faction", "VERTICON"),
                yml.getString(key + ".role", "Custom Character"),
                yml.getString(key + ".kairosConnection", "Unknown")
            ));
        }
    }

    public void save() {
        if (file == null) file = new File(plugin.getDataFolder(), "characters.yml");
        YamlConfiguration yml = new YamlConfiguration();
        for (Map.Entry<String, CharacterProfile> e : characters.entrySet()) {
            String p = e.getKey();
            CharacterProfile c = e.getValue();
            yml.set(p + ".name", c.name());
            yml.set(p + ".faction", c.faction());
            yml.set(p + ".role", c.role());
            yml.set(p + ".kairosConnection", c.kairosConnection());
        }
        try { yml.save(file); }
        catch (IOException ex) { plugin.getLogger().severe("Could not save characters.yml: " + ex.getMessage()); }
    }

    public boolean create(String name) {
        String key = name.toLowerCase();
        if (characters.containsKey(key)) return false;
        characters.put(key, new CharacterProfile(name, "VERTICON", "Custom Character", "Connected"));
        save();
        return true;
    }

    public CharacterProfile get(String name) { return characters.get(name.toLowerCase()); }
    public Collection<CharacterProfile> all() { return Collections.unmodifiableCollection(characters.values()); }

    public record CharacterProfile(String name, String faction, String role, String kairosConnection) {}
}
