package me.muffinjello.shortcutsay;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Shortcutsay extends JavaPlugin implements Listener {
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("Welcome, " + event.getPlayer().getDisplayName() + "!");
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(cmd.getName().equalsIgnoreCase("+say") && sender.hasPermission("shortcutsay.use")){
            String s = "";
            for (int x = 0; x < args.length; x++){
                s = s + args[x] + " ";
            }
            Bukkit.broadcastMessage(s.replaceAll("(&([a-f0-9]))", "§$2"));
        }
        return true;
    }
}

