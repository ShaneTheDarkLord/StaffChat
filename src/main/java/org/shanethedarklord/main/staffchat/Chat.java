package org.shanethedarklord.main.staffchat;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {
    public StaffChat plugin;

    public Chat(StaffChat pl) {
        this.plugin = pl;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String Prefix = ChatColor.translateAlternateColorCodes('&', "&7&l[&6&lLocalStaff&7&l]");
        String msg = e.getMessage();

        if (Commands.Insc.contains(p)) {
            e.setCancelled(true);
            for (Player staff : Bukkit.getServer().getOnlinePlayers()) {
                if (p.hasPermission("staffchat.see")) {
                    staff.sendMessage(Prefix + " " + p.getDisplayName() +  " " + ChatColor.GOLD + ":" + ChatColor.YELLOW + " " + msg);
                }
            }
        }

    }
}