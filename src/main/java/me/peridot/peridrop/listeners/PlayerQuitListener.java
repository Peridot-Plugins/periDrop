package me.peridot.peridrop.listeners;

import me.peridot.peridrop.PeriDrop;
import me.peridot.peridrop.user.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    private final PeriDrop plugin;

    public PlayerQuitListener(PeriDrop plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        User user = plugin.getUserManager().createUser(player);
        plugin.getDatabaseManager().getUserDatabase().saveUser(user);
        plugin.getRankManager().update(user);
        plugin.getUserManager().removeUser(player);
    }
}