package me.aurium.beetle.branch.spigot;

import me.aurium.beetle.branch.launchpoints.CentralizedManager;
import me.aurium.beetle.branch.launchpoints.CentralizedManagerBinder;
import me.aurium.beetle.branch.launchpoints.typeadapter.ManagerAdapter;
import me.aurium.beetle.branch.launchpoints.base.NodeBaseBuilder;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotManager implements CentralizedManager<CommandSender, JavaPlugin> {

    private final SenderAdapter adapter = new SenderAdapter();

    @Override
    public CentralizedManagerBinder getBinder(JavaPlugin platform) {
        return new SpigotManagerBinder(platform);
    }

    @Override
    public NodeBaseBuilder<CommandSender> newCommand() {
        return newCommand(adapter);
    }

    @Override
    public <C extends CommandSender> NodeBaseBuilder<C> newCommand(ManagerAdapter<CommandSender, C> adapter) {
        return new NodeBaseBuilder<>(new SpigotContextProvider<>(adapter));
    }


}
