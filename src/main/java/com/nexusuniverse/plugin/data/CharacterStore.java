package com.nexusuniverse.plugin.data;
import com.nexusuniverse.plugin.NexusUniversePlugin;
import com.nexusuniverse.plugin.lore.LoreLayer;
import com.nexusuniverse.plugin.transformer.*;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.*; import java.util.*;
public final class CharacterStore {
 private final NexusUniversePlugin plugin; private final Map<String,TransformerCharacter> data=new LinkedHashMap<>(); private File file;
 public CharacterStore(NexusUniversePlugin p){plugin=p;}
 public void load(){ if(!plugin.getDataFolder().exists())plugin.getDataFolder().mkdirs(); file=new File(plugin.getDataFolder(),"characters.yml"); if(!file.exists())return; YamlConfiguration y=YamlConfiguration.loadConfiguration(file); ConfigurationSection r=y.getConfigurationSection("characters"); if(r==null)return;
  for(String k:r.getKeys(false)){ConfigurationSection s=r.getConfigurationSection(k); if(s==null)continue; LoreLayer l; try{l=LoreLayer.valueOf(s.getString("lore-layer","NEXUS"));}catch(Exception e){l=LoreLayer.NEXUS;} TransformationState st; try{st=TransformationState.valueOf(s.getString("state","ROBOT"));}catch(Exception e){st=TransformationState.ROBOT;} data.put(k.toLowerCase(),new TransformerCharacter(s.getString("name",k),l,s.getString("species","Cybertronian"),s.getString("faction","VERTICONS"),s.getString("rank","Recruit"),s.getString("alt-mode","Unknown"),st,s.getInt("max-energon",100)));}}
 public void save(){if(file==null)file=new File(plugin.getDataFolder(),"characters.yml"); YamlConfiguration y=new YamlConfiguration(); for(TransformerCharacter c:data.values()){String p="characters."+c.name().toLowerCase(); y.set(p+".name",c.name());y.set(p+".lore-layer",c.loreLayer().name());y.set(p+".species",c.species());y.set(p+".faction",c.faction());y.set(p+".rank",c.rank());y.set(p+".alt-mode",c.altMode());y.set(p+".state",c.state().name());y.set(p+".max-energon",c.maxEnergon());} try{y.save(file);}catch(IOException e){plugin.getLogger().severe(e.getMessage());}}
 public boolean create(String n,LoreLayer l,String f){if(data.containsKey(n.toLowerCase()))return false; data.put(n.toLowerCase(),new TransformerCharacter(n,l,"Cybertronian",f,"Recruit","Unknown",TransformationState.ROBOT,plugin.getConfig().getInt("energon.default-max",100)));save();return true;}
 public TransformerCharacter get(String n){return data.get(n.toLowerCase());}
 public Collection<TransformerCharacter> all(){return Collections.unmodifiableCollection(data.values());}
 public boolean transform(String n){TransformerCharacter c=get(n);if(c==null)return false; TransformationState next=c.state()==TransformationState.ROBOT?TransformationState.VEHICLE:TransformationState.ROBOT;data.put(n.toLowerCase(),new TransformerCharacter(c.name(),c.loreLayer(),c.species(),c.faction(),c.rank(),c.altMode(),next,c.maxEnergon()));save();return true;}
}
