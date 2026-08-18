package com.nexusuniverse.kairos.commands;

import com.nexusuniverse.kairos.KairosPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.*;

public final class KairosCommand implements CommandExecutor {
    private final KairosPlugin plugin;
    public KairosCommand(KairosPlugin plugin) { this.plugin = plugin; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.DARK_PURPLE + "Kairos: " + ChatColor.WHITE +
            "The Nexus is under observation. Systems are operational.");
        sender.sendMessage(ChatColor.GRAY + "Characters registered: " +
            plugin.getCharacterStore().all().size());
        return true;
    }
}
