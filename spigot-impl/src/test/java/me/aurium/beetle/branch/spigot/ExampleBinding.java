package me.aurium.beetle.branch.spigot;

import org.bukkit.plugin.java.JavaPlugin;

public class ExampleBinding extends JavaPlugin {


    private static final SpigotManager manager = new SpigotManager();

    @Override
    public void onEnable() {
        manager.getBinder(this).bind();




    }
}
