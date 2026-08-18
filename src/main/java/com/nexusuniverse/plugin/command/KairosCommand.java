package com.nexusuniverse.plugin.command;
import com.nexusuniverse.plugin.kairos.KairosService;
import org.bukkit.ChatColor; import org.bukkit.command.*;
public final class KairosCommand implements CommandExecutor {
 private final KairosService k; public KairosCommand(KairosService k){this.k=k;}
 public boolean onCommand(CommandSender s,Command c,String l,String[] a){if(a.length==0||a[0].equalsIgnoreCase("status")){s.sendMessage(ChatColor.DARK_PURPLE+k.status());return true;}if(a[0].equalsIgnoreCase("message")&&a.length>1){k.speak(s,String.join(" ",java.util.Arrays.copyOfRange(a,1,a.length)));return true;}s.sendMessage(ChatColor.RED+"/kairos [status|message <text>]");return true;}
}
