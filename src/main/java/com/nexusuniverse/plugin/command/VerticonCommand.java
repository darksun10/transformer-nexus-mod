package com.nexusuniverse.plugin.command;
import com.nexusuniverse.plugin.data.CharacterStore; import com.nexusuniverse.plugin.lore.LoreLayer;
import org.bukkit.ChatColor; import org.bukkit.command.*;
public final class VerticonCommand implements CommandExecutor {
 private final CharacterStore store; public VerticonCommand(CharacterStore s){store=s;}
 public boolean onCommand(CommandSender s,Command c,String l,String[] a){if(a.length==0||a[0].equalsIgnoreCase("list")){s.sendMessage(ChatColor.AQUA+"Verticons: "+store.all().stream().filter(x->x.faction().equalsIgnoreCase("VERTICONS")).map(x->x.name()).reduce((x,y)->x+", "+y).orElse("none"));return true;}if(a[0].equalsIgnoreCase("create")&&a.length>1){s.sendMessage(store.create(a[1],LoreLayer.NEXUS,"VERTICONS")?ChatColor.GREEN+"Created Verticon: "+a[1]:ChatColor.RED+"Already exists.");return true;}if(a[0].equalsIgnoreCase("info")&&a.length>1){var x=store.get(a[1]);if(x==null||!x.faction().equalsIgnoreCase("VERTICONS")){s.sendMessage(ChatColor.RED+"Verticon not found.");return true;}s.sendMessage(ChatColor.GOLD+x.name()+ChatColor.GRAY+" | "+x.rank()+" | "+x.state()+" | "+x.altMode());return true;}s.sendMessage(ChatColor.RED+"/verticon <create|list|info>");return true;}
}
