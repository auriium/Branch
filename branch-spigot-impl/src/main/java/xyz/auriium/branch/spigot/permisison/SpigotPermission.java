package xyz.auriium.branch.spigot.permisison;

import xyz.auriium.branch.base.NodeContext;
import xyz.auriium.branch.base.permissions.Permission;
import org.bukkit.command.CommandSender;

public class SpigotPermission implements Permission<CommandSender> {

    private final String permission;

    public SpigotPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public boolean attempt(NodeContext<CommandSender> nodeContext) {
        return nodeContext.hasStringPermissible(permission);
    }

    @Override
    public String failureIdentifiableName() {
        return "'"  + permission + "'";
    }
}
