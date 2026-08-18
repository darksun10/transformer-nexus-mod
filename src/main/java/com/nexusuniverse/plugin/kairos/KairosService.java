package com.nexusuniverse.plugin.kairos;
import com.nexusuniverse.plugin.NexusUniversePlugin;
import org.bukkit.ChatColor; import org.bukkit.command.CommandSender;
public final class KairosService {
 private final NexusUniversePlugin plugin; public KairosService(NexusUniversePlugin p){plugin=p;}
 public String status(){return "Kairos is active. The Nexus is under observation.";}
 public void speak(CommandSender s,String m){s.sendMessage(ChatColor.DARK_PURPLE+"Kairos » "+ChatColor.LIGHT_PURPLE+m);}
}
