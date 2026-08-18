package com.nexusuniverse.plugin.command;
import com.nexusuniverse.plugin.data.CharacterStore;
import com.nexusuniverse.plugin.lore.LoreLayer;
import org.bukkit.ChatColor; import org.bukkit.command.*;
public final class TransformerCommand implements CommandExecutor {
 private final CharacterStore store; public TransformerCommand(CharacterStore s){store=s;}
 public boolean onCommand(CommandSender s,Command c,String l,String[] a){if(a.length==0){s.sendMessage(ChatColor.AQUA+"/transformer create <name>");s.sendMessage(ChatColor.AQUA+"/transformer info <name>");s.sendMessage(ChatColor.AQUA+"/transformer transform <name>");return true;}switch(a[0].toLowerCase()){case"create"->{if(a.length<2){s.sendMessage(ChatColor.RED+"Usage: /transformer create <name>");return true;}s.sendMessage(store.create(a[1],LoreLayer.NEXUS,"VERTICONS")?ChatColor.GREEN+"Created "+a[1]:ChatColor.RED+"Character already exists.");}case"info"->{if(a.length<2)return true;var x=store.get(a[1]);if(x==null){s.sendMessage(ChatColor.RED+"Not found.");return true;}s.sendMessage(ChatColor.GOLD+x.name()+ChatColor.GRAY+" | "+x.loreLayer()+" | "+x.faction()+" | "+x.rank()+" | "+x.state()+" | Alt: "+x.altMode());}case"transform"->{if(a.length<2)return true;s.sendMessage(store.transform(a[1])?ChatColor.GREEN+"Transformation state changed.":ChatColor.RED+"Character not found.");}default->s.sendMessage(ChatColor.RED+"Unknown subcommand.");}return true;}
}
