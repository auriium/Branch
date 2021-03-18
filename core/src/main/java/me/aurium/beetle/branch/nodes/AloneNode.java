package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.branch.CommandNode;

/**
 * Marker interface for a node that is alone (so not branching, but not merging either)
 */
public interface AloneNode<T> extends CommandNode<T> {
}
