package com.nexusuniverse.plugin;
import com.nexusuniverse.plugin.command.*;
import com.nexusuniverse.plugin.data.CharacterStore;
import com.nexusuniverse.plugin.faction.FactionManager;
import com.nexusuniverse.plugin.kairos.KairosService;
import org.bukkit.plugin.java.JavaPlugin;
public final class NexusUniversePlugin extends JavaPlugin {
 private CharacterStore characters; private FactionManager factions; private KairosService kairos;
 public void onEnable() {
  saveDefaultConfig(); saveResource("factions.yml",false); saveResource("ranks.yml",false); saveResource("lore.yml",false); saveResource("abilities.yml",false);
  characters=new CharacterStore(this); characters.load(); factions=new FactionManager(this); factions.load(); kairos=new KairosService(this);
  getCommand("kairos").setExecutor(new KairosCommand(kairos));
  getCommand("transformer").setExecutor(new TransformerCommand(characters));
  getCommand("faction").setExecutor(new FactionCommand(factions));
  getCommand("verticon").setExecutor(new VerticonCommand(characters));
  getLogger().info("Nexus Universe Transformers framework enabled. Kairos online.");
 }
 public void onDisable(){ if(characters!=null) characters.save(); }
 public CharacterStore getCharacterStore(){return characters;}
 public FactionManager getFactionManager(){return factions;}
 public KairosService getKairosService(){return kairos;}
}
