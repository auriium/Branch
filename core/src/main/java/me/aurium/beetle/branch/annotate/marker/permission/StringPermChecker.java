package me.aurium.beetle.branch.annotate.marker.permission;

import me.aurium.beetle.branch.fallback.permission.strategies.StringPermission;

public interface StringPermChecker {

    StringPermission<?> get(String identifierToMakeWith);

}
