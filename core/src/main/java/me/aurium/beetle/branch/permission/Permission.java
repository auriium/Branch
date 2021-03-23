package me.aurium.beetle.branch.permission;

import me.aurium.beetle.branch.context.NodeContext;

import java.util.function.Predicate;

/**
 *
 */
public interface Permission<T> {

   Predicate<NodeContext<T>> attempt();

}
