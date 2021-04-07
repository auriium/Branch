package me.aurium.beetle.branch.nodes.model;

import me.aurium.beetle.branch.handlers.api.BranchHandler;
import me.aurium.beetle.branch.nodes.results.SearchInput;
import me.aurium.beetle.branch.nodes.results.SearchInfo;
import me.aurium.beetle.branch.fallback.permissions.Permission;

/**
 * Base object
 * @param <T> fuck
 */
public interface CommandNode<T> {

    SearchInfo<T> getSpecificNode(SearchInput path);
    BranchHandler<T> getHandling();


    /**
     * Gets the permission required to execute and interact with this node. Depending on the base, this may cause the node to become locked, or just completely be ignored.
     * @return the permission binding
     */
    Permission<T> getPermission();
}
