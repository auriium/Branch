package me.aurium.beetle.branch.spigot;

import me.aurium.beetle.branch.nodes.builders.SingleBuilder;
import org.bukkit.plugin.java.JavaPlugin;

public class ExampleBinding extends JavaPlugin {


    private static final SpigotManager manager = new SpigotManager();

    @Override
    public void onEnable() {
        manager.getBinder(this).bind();




    }
}
