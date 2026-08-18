package com.nexusuniverse.plugin.faction;
import com.nexusuniverse.plugin.NexusUniversePlugin;
import com.nexusuniverse.plugin.lore.LoreLayer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File; import java.util.*;
public final class FactionManager {
 private final NexusUniversePlugin plugin; private final Map<String,Faction> factions=new LinkedHashMap<>();
 public FactionManager(NexusUniversePlugin p){plugin=p;}
 public void load(){YamlConfiguration y=YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(),"factions.yml")); for(String id:List.of("autobots","decepticons","verticons")){ConfigurationSection s=y.getConfigurationSection(id);if(s==null)continue;LoreLayer l;try{l=LoreLayer.valueOf(s.getString("lore-layer","NEXUS"));}catch(Exception e){l=LoreLayer.NEXUS;}factions.put(id,new Faction(id,s.getString("display-name",id),l,"CUSTOM".equalsIgnoreCase(s.getString("type","CUSTOM"))));}}
 public Collection<Faction> all(){return Collections.unmodifiableCollection(factions.values());}
}
