package org.shanethedarklord.main.staffchat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Commands implements CommandExecutor {
    public StaffChat plugin;

    public Commands(StaffChat pl) {
        this.plugin = pl;
    }

    public static ArrayList<Player> Insc = new ArrayList<Player>();

    String Prefix = ChatColor.translateAlternateColorCodes('&', "&7&l[&6&lLocalStaff&7&l]");
    String Enabled = ChatColor.translateAlternateColorCodes('&', "&7&l[&6&lStaff&e&lChat&7&l] &fhas been &a&lenabled");
    String Disabled = ChatColor.translateAlternateColorCodes('&', "&7&l[&6&lStaff&e&lChat&7&l] &fhas been &c&ldisabled");
    String NoPerm = ChatColor.translateAlternateColorCodes('&', "&cYou do not have permission to use this command");

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if (cmd.getName().equalsIgnoreCase("atoggle")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("You must be a player to use this command");
                return true;
            }
            Player p = (Player) sender;

            if (args.length == 0) {
                if (!(p.hasPermission("staffchat.use"))) {
                    p.sendMessage(NoPerm);
                    return true;
                }
                if (Insc.contains(p)) {
                    Insc.remove(p);
                    p.sendMessage(Disabled);
                    return true;
                } else
                    Insc.add(p);
                p.sendMessage(Enabled);

                return true;
            }
            if (args.length >= 1) {
                p.sendMessage(Prefix + ChatColor.GRAY + "Usage: /atoggle to toggle staffchat");
                return true;
            }
        }
        return false;
    }
}
