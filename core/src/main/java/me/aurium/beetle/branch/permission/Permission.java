package me.aurium.beetle.branch.permission;

import me.aurium.beetle.branch.context.StagedContext;

/**
 *
 */
public interface Permission<T> {

   boolean attempt(StagedContext<T> context);

}
