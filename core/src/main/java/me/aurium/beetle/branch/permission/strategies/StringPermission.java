package me.aurium.beetle.branch.permission.strategies;

import me.aurium.beetle.branch.permission.Permission;

/**
 * Represents a permission that is controlled by a string identifier
 * @param <T> the string identifier, duh
 */
public interface StringPermission<T> extends Permission<T> {

    String permissionIdentifier();

}
