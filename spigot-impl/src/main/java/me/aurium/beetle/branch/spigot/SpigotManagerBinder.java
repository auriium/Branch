package me.aurium.beetle.branch.spigot;

import me.aurium.beetle.branch.launchpoints.CentralizedManagerBinder;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotManagerBinder implements CentralizedManagerBinder {

    private final JavaPlugin plugin;

    public SpigotManagerBinder(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void bind() { //TODO implement
        plugin.getServer().getPluginManager();
    }
}
