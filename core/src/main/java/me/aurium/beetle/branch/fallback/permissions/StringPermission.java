package me.aurium.beetle.branch.fallback.permissions;

/**
 * Represents a permission that is controlled by a string identifier
 * @param <T> the string identifier, duh
 */
public interface StringPermission<T> extends Permission<T> {

    String permissionIdentifier();

}
