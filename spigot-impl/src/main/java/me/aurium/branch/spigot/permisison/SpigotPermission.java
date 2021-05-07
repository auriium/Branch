package me.aurium.branch.spigot.permisison;

import me.aurium.branch.fallback.permissions.Permission;
import org.bukkit.command.CommandSender;

public class SpigotPermission implements Permission<CommandSender> {

    private final String permission;

    public SpigotPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public boolean attempt(CommandSender sender, String alias, String[] args) {
        return sender.hasPermission(permission);
    }

    @Override
    public String failureIdentifiableName() {
        return "'"  + permission + "'";
    }
}
