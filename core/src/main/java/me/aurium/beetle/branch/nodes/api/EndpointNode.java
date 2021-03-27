package me.aurium.beetle.branch.nodes.api;

/**
 * Marker interface for a node that is alone (so not branching, but not merging either)
 *
 * This usually means the end of whatever branch it is connected to.
 */
public interface EndpointNode<T> extends IdentifiableNode<T> {
}
