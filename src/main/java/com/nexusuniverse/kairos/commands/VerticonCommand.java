package com.nexusuniverse.kairos.commands;

import com.nexusuniverse.kairos.data.CharacterStore;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import java.util.stream.Collectors;

public final class VerticonCommand implements CommandExecutor {
    private final CharacterStore store;
    public VerticonCommand(org.bukkit.plugin.Plugin plugin, CharacterStore store) { this.store = store; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.AQUA + "/verticon create <name>");
            sender.sendMessage(ChatColor.AQUA + "/verticon list");
            sender.sendMessage(ChatColor.AQUA + "/verticon info <name>");
            sender.sendMessage(ChatColor.AQUA + "/verticon assign <player> <name>");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "create" -> {
                if (args.length < 2) { sender.sendMessage(ChatColor.RED + "Usage: /verticon create <name>"); return true; }
                sender.sendMessage(store.create(args[1])
                    ? ChatColor.GREEN + "Created Verticon: " + args[1]
                    : ChatColor.RED + "That character already exists.");
            }
            case "list" -> {
                String list = store.all().stream().map(CharacterStore.CharacterProfile::name)
                    .collect(Collectors.joining(", "));
                sender.sendMessage(ChatColor.YELLOW + "Verticons: " + (list.isEmpty() ? "none" : list));
            }
            case "info" -> {
                if (args.length < 2) { sender.sendMessage(ChatColor.RED + "Usage: /verticon info <name>"); return true; }
                var c = store.get(args[1]);
                if (c == null) { sender.sendMessage(ChatColor.RED + "Character not found."); return true; }
                sender.sendMessage(ChatColor.GOLD + c.name() + ChatColor.GRAY +
                    " | Faction: " + c.faction() + " | Role: " + c.role() +
                    " | Kairos: " + c.kairosConnection());
            }
            case "assign" -> sender.sendMessage(ChatColor.GRAY +
                "Assignment command is reserved for the next development phase.");
            default -> sender.sendMessage(ChatColor.RED + "Unknown subcommand.");
        }
        return true;
    }
}
