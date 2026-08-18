package com.nexusuniverse.plugin.command;
import com.nexusuniverse.plugin.faction.FactionManager;
import org.bukkit.ChatColor; import org.bukkit.command.*;
public final class FactionCommand implements CommandExecutor {
 private final FactionManager m; public FactionCommand(FactionManager m){this.m=m;}
 public boolean onCommand(CommandSender s,Command c,String l,String[] a){s.sendMessage(ChatColor.YELLOW+"Factions: "+m.all().stream().map(f->f.displayName()+" ["+f.loreLayer()+"]").reduce((x,y)->x+", "+y).orElse("none"));return true;}
}
